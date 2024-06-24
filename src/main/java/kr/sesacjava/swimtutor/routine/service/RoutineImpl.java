package kr.sesacjava.swimtutor.routine.service;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDetailDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseTrainingForRoutineDTO;
import kr.sesacjava.swimtutor.routine.entity.Routine;
import kr.sesacjava.swimtutor.routine.entity.Training;
import kr.sesacjava.swimtutor.routine.entity.TrainingForRoutine;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import kr.sesacjava.swimtutor.routine.repository.RoutineRepository;
import kr.sesacjava.swimtutor.routine.repository.TrainingForRoutineRepository;
import kr.sesacjava.swimtutor.routine.repository.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoutineImpl implements RoutineService {

    private static final Logger LOG = LoggerFactory.getLogger(RoutineImpl.class);
    private RoutineRepository routineRepo;
    private TrainingRepository trainingRepo;
    private TrainingForRoutineRepository trainingForRoutineRepo;

    @Autowired
    public RoutineImpl(RoutineRepository routineRepo, TrainingRepository trainingRepo, TrainingForRoutineRepository trainingForRoutineRepo) {
//        LOG.info("RoutineImpl 생성자 호출");
        this.routineRepo = routineRepo;
        this.trainingRepo = trainingRepo;
        this.trainingForRoutineRepo = trainingForRoutineRepo;
    }

    // 루틴 목록
    public List<ResponseRoutineDTO> getRoutines() {
//        LOG.info("getRoutines 호출");
        List<Routine> routines = routineRepo.findAll();
        List<ResponseRoutineDTO> responseRoutineDTOs = new ArrayList<>();
        for (Routine routine : routines) {
            ResponseRoutineDTO responseRoutineDTO = ResponseRoutineDTO.builder()
                    .routineName(routine.getRoutineName())
                    .poolLength(routine.getPoolLength())
                    .targetDistance(routine.getTargetDistance())
                    .selStrokes(routine.getSelStrokes())
                    .created(routine.getCreated())
                    .updated(routine.getUpdated())
                    .build();
            responseRoutineDTOs.add(responseRoutineDTO);
        }
        return responseRoutineDTOs;
    }

    // 루틴 상세
    @Transactional
    public ResponseRoutineDetailDTO getRoutineDetail(RoutineId routineId) {
//        LOG.info("getRoutineDetail 호출");
        ResponseRoutineDetailDTO responseRoutineDetailDTO = null;
        List<ResponseTrainingForRoutineDTO> responseTrainingForRoutineDTOS = new ArrayList<>();

        // 루틴 정보
        Routine routine = routineRepo.getReferenceById(routineId);
        // 루틴에 대한 훈련 정보
        List<TrainingForRoutine> trainingsForRoutine = trainingForRoutineRepo.findAllByRoutineNo(routineId.getRoutineNo());

        // 루틴에 대한 훈련 정보를 DTO로 변환
        for (TrainingForRoutine trainingForRoutine : trainingsForRoutine) {
            Training training = trainingRepo.getReferenceById(trainingForRoutine.getTrainingId());
            ResponseTrainingForRoutineDTO responseTrainingForRoutineDTO = ResponseTrainingForRoutineDTO.builder()
                    .session(trainingForRoutine.getSession())
                    .strokeName(training.getStrokeName())
                    .distance(training.getDistance())
                    .sets(training.getSets())
                    .build();
            responseTrainingForRoutineDTOS.add(responseTrainingForRoutineDTO);
        }
        return ResponseRoutineDetailDTO.builder()
                .routineName(routine.getRoutineName())
                .targetDistance(routine.getTargetDistance())
                .poolLength(routine.getPoolLength())
                .selStrokes(routine.getSelStrokes())
                .created(routine.getCreated())
                .updated(routine.getUpdated())
                .responseTrainingForRoutineDTOS(responseTrainingForRoutineDTOS)
                .build();
    }

    // 루틴 저장
    public Routine saveRoutine(RequestRoutineDTO requestRoutineDTO) {
//        LOG.info("saveRoutine 호출");
        int lastRoutineNo = routineRepo.findMaxRoutineNo();
        return routineRepo.save(Routine.builder()
                .routineNo(lastRoutineNo == 0 ? 1 : lastRoutineNo + 1)
                .oauthLoginId(requestRoutineDTO.getOauthLoginId())
                .oauthLoginPlatform(requestRoutineDTO.getOauthLoginPlatform())
                .routineName(requestRoutineDTO.getRoutineName())
                .poolLength(requestRoutineDTO.getPoolLength())
                .targetDistance(requestRoutineDTO.getTargetDistance())
                .selStrokes(requestRoutineDTO.getSelStrokes())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build()
        );
    }

    // 루틴 삭제
    public Routine deleteRoutine(RoutineId routineId) {
//        LOG.info("RoutineImpl - deleteRoutine 호출");
        Routine routine = routineRepo.findById(routineId).orElse(null);
        routineRepo.deleteById(routineId);
        return routine;
    }
}
