package kr.sesacjava.swimtutor.routine.service;

import kr.sesacjava.swimtutor.common.requestLog.RequestLogRepository;
import kr.sesacjava.swimtutor.leveltest.service.LevelLogService;
import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseTrainingForRoutineDTO;
import kr.sesacjava.swimtutor.routine.entity.Training;
import kr.sesacjava.swimtutor.routine.entity.TrainingForRoutine;
import kr.sesacjava.swimtutor.routine.repository.RoutineRepository;
import kr.sesacjava.swimtutor.routine.repository.TrainingForRoutineRepository;
import kr.sesacjava.swimtutor.routine.repository.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class NewRoutineService {

    private static final Logger log = LoggerFactory.getLogger(LevelLogService.class);
    private RoutineRepository routineRepo;
    private RequestLogRepository requestLogRepo;
    private TrainingRepository trainingRepo;

    private List<String> sessions = Arrays.asList("Warm-up", "Main", "Cool-down");
    private TrainingForRoutineRepository trainingForRoutineRepo;

    @Autowired
    public NewRoutineService(RoutineRepository routineRepo, RequestLogRepository requestLogRepo, TrainingRepository trainingRepo, TrainingForRoutineRepository trainingForRoutineRepo) {
        log.info("NewRoutineService created");
        this.routineRepo = routineRepo;
        this.requestLogRepo = requestLogRepo;
        this.trainingRepo = trainingRepo;
        this.trainingForRoutineRepo = trainingForRoutineRepo;
    }

    // 세션별 목표거리 계산 로직
    private int calculateDistanceForSession(int baseDistance, double sessionPercentage, double variationPercentage) {
        log.info("calculateDistanceForSession");
        // 세션 목표거리의 하한값
        double minDistance = baseDistance * sessionPercentage * (1 - variationPercentage);
        // 세션 목표거리의 상한값
        double maxDistance = baseDistance * sessionPercentage * (1 + variationPercentage);
        // 가장 가까운 50m 단위로 반올림
        int sessionTargetDistance = (int) (Math.round(maxDistance / 50) * 50);

        return sessionTargetDistance;
    }

    // 세션별 선택 가능 훈련 목록 선정 로직
    private List<Training> selectAvailableTrainings(int sessionTargetDistance, String selStrokes) {
        log.info("selectAvailableTrainings");

        List<Training> allTrainings = trainingRepo.findAll();
        List<Training> availableTrainings = new ArrayList<>();
        List<String> selStrokeList = Arrays.asList(selStrokes.split(","));

        // 모든 훈련에 대해 반복
        for (Training training : allTrainings) {
            // 선택한 영법에 포함되는 훈련이고
            if (selStrokeList.contains(training.getStrokeName())
                    // 이미 확인한 훈련이 아니고
                    && !availableTrainings.contains(training)
                    // 훈련 거리가 목표 거리보다 작거나 같을 때
                    && training.getDistance() * training.getSets() <= sessionTargetDistance
            ) {
                // 선택 가능 훈련 목록에 추가
                availableTrainings.add(training);
            }
        }
        return availableTrainings;
    }

    // 세션별 훈련 선택 ️로직
    /* 목표거리가 0이 되는 훈련이 없을 수 있음 -> 50m 단위로 다양한 훈련 데이터 생성 필요 */
    private List<Training> selectTrainingsForSession(int sessionTargetDistance, List<Training> availableTrainings) {
        log.info("selectTrainingsForSession");
        Random rand = new Random();
        List<Training> selectedTrainings = new ArrayList<>();

        // 목표거리가 0이 될 때까지 훈련을 선택
        for (int d = sessionTargetDistance; d > 0; ) {
            // 선택 가능한 훈련 중에서 랜덤으로 선택
            int index = rand.nextInt(availableTrainings.size());
            Training selectedTraining = availableTrainings.get(index);

            // 선택된 훈련을 세션에 추가하고, 목표거리를 갱신
            selectedTrainings.add(selectedTraining);
            d = d - (selectedTraining.getDistance() * selectedTraining.getSets());

            // 선택된 훈련을 사용한 후, 다시 선택되지 않도록 목록에서 제거
            availableTrainings.remove(index);
        }
        return selectedTrainings;
    }

    // 루틴 생성
    public List<ResponseTrainingForRoutineDTO> createRoutine(int targetDistance, String selStrokes) {
        log.info("selectTrainingsForRoutine");
        List<Double> sessionPercentages = Arrays.asList(0.3, 0.6, 0.1); // 세션별 목표거리 비율
        Double variationPercentage = 0.05;                              // 목표거리 변동률
        List<ResponseTrainingForRoutineDTO> selectedTrainingsForRoutine = new ArrayList<>(
        );           // 선택된 훈련 목록

        // 세션별 훈련 선택
        for (int i = 0; i < sessions.size(); i++) {
            ResponseTrainingForRoutineDTO selectedTraining = new ResponseTrainingForRoutineDTO();
            // 세션
            selectedTraining.setSession(sessions.get(i));

            // 목표거리
            int sessionTargetDistance = calculateDistanceForSession(targetDistance, sessionPercentages.get(i), variationPercentage);
            // 선택 가능한 훈련 목록
            List<Training> availableTrainingsForSession = selectAvailableTrainings(sessionTargetDistance, selStrokes);
            // 훈련 선택
            List<Training> selectedTrainings = selectTrainingsForSession(sessionTargetDistance, availableTrainingsForSession);

            // 선택된 훈련을 루틴에 추가
            for (Training training : selectedTrainings) {
                selectedTraining.setTrainingId(training.getTrainingId());
                selectedTraining.setStrokeName(training.getStrokeName());
                selectedTraining.setDistance(training.getDistance());
                selectedTraining.setSets(training.getSets());
                selectedTrainingsForRoutine.add(selectedTraining);
            }
        }
        // 훈련 선택 결과 반환
        return selectedTrainingsForRoutine;
    }

    // 루틴 저장
    public List<ResponseTrainingForRoutineDTO> saveTrainingsForRoutine(RequestRoutineDTO routine) {
        log.info("create routine");

        int targetDistance = routine.getTargetDistance();
        String selStrokes = routine.getSelStrokes();

        // 루틴에 포함될 훈련 목록 선택
        List<ResponseTrainingForRoutineDTO> trainings = createRoutine(targetDistance, selStrokes);
        List<TrainingForRoutine> trainingsForRoutine = new ArrayList<>();

        // 선택된 훈련을 루틴에 저장
        for (ResponseTrainingForRoutineDTO training : trainings) {
            TrainingForRoutine trainingForRoutine = new TrainingForRoutine(
                    routine.getRoutineId(),
                    routine.getOauthLoginId(),
                    routine.getOauthLoginPlatform(),
                    training.getSession(),
                    training.getTrainingId(),
                    routine.getCreated(),
                    routine.getUpdated()
            );
            trainingsForRoutine.add(trainingForRoutine);
        }
        trainingForRoutineRepo.saveAll(trainingsForRoutine);
        log.info("saveAll trainingsForRoutine");
        return trainings;
    }
}
