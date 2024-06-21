package kr.sesacjava.swimtutor.routine.service;

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

import java.util.ArrayList;
import java.util.List;

@Service
public class RoutineImpl implements RoutineService {

    private static final Logger log = LoggerFactory.getLogger(RoutineImpl.class);
    private RoutineRepository routineRepo;
    private TrainingRepository trainingRepo;
    private TrainingForRoutineRepository trainingForRoutineRepo;

    @Autowired
    public RoutineImpl(RoutineRepository routineRepo, TrainingRepository trainingRepo, TrainingForRoutineRepository trainingForRoutineRepo) {
        log.info("RoutineImpl created");
        this.routineRepo = routineRepo;
        this.trainingRepo = trainingRepo;
        this.trainingForRoutineRepo = trainingForRoutineRepo;
    }

    // 루틴 목록
    public List<ResponseRoutineDTO> getRoutines() {
        log.info("RoutineImpl getRoutines");
        List<Routine> routines = routineRepo.findAll();
        List<ResponseRoutineDTO> responseRoutineDTOs = new ArrayList<>();
        for (Routine routine : routines) {
            ResponseRoutineDTO responseRoutineDTO = new ResponseRoutineDTO(
                    routine.getRoutineName(),
                    routine.getPoolLength(),
                    routine.getTargetDistance(),
                    routine.getSelStrokes(),
                    routine.getCreated(),
                    routine.getUpdated()
            );
            responseRoutineDTOs.add(responseRoutineDTO);
        }
        return responseRoutineDTOs;
    }

    // 루틴 상세
    public ResponseRoutineDetailDTO getRoutineDetail(RoutineId routineId) {
        log.info("RoutineImpl getRoutine");
        // 루틴 정보 조회
        Routine routine = routineRepo.findById(routineId).orElse(null);

        // 루틴 정보가 존재할 경우
        if (routine != null) {
            List<TrainingForRoutine> trainingsForRoutine = trainingForRoutineRepo.findByRoutineId(routineId);
            List<ResponseTrainingForRoutineDTO> responseRoutineDetailDTOs = new ArrayList<>();
            // 루틴에 포함된 훈련 정보 조회
            for (TrainingForRoutine trainingForRoutine : trainingsForRoutine) {
                Training training = trainingRepo.findById(trainingForRoutine.getTrainingId()).orElse(null);
                // 훈련 정보가 존재할 경우
                if (training != null) {
                    ResponseTrainingForRoutineDTO responseTrainingForRoutineDTO = new ResponseTrainingForRoutineDTO(
                            trainingForRoutine.getSession(),
                            training.getStrokeName(),
                            training.getDistance(),
                            training.getSets()
                    );
                    responseRoutineDetailDTOs.add(responseTrainingForRoutineDTO);
                }
            }
            ResponseRoutineDetailDTO responseRoutineDetailDTO = new ResponseRoutineDetailDTO(
                    routine.getRoutineName(),
                    routine.getPoolLength(),
                    routine.getTargetDistance(),
                    routine.getSelStrokes(),
                    routine.getCreated(),
                    routine.getUpdated(),
                    responseRoutineDetailDTOs
            );
            return responseRoutineDetailDTO;
        }
        return null;
    }

    // 루틴 저장
    public Routine saveRoutine(RequestRoutineDTO requestRoutineDTO) {
        log.info("RoutineImpl saveRoutine");
        Routine routine = new Routine();
        return routineRepo.save(routine);
    }

    // 루틴 삭제
    public Routine deleteRoutine(RoutineId routineId) {
        log.info("RoutineImpl deleteRoutine");
        Routine routine = routineRepo.findById(routineId).orElse(null);
        routineRepo.deleteById(routineId);
        return routine;
    }
}
