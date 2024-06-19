package kr.sesacjava.swimtutor.routine.service;

import kr.sesacjava.swimtutor.common.requestLog.RequestLogRepository;
import kr.sesacjava.swimtutor.leveltest.service.LevelLogService;
import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDetailDTO;
import kr.sesacjava.swimtutor.routine.entity.Routine;
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
public class RoutineService {

    private static final Logger log = LoggerFactory.getLogger(LevelLogService.class);
    private RequestLogRepository requestLogRepo;
    private RoutineRepository routineRepo;
    private TrainingRepository trainingRepo;
    private TrainingForRoutineRepository trainingForRoutineRepo;
    private RoutineRepository RoutineRepo;

    @Autowired
    public RoutineService(RequestLogRepository requestLogRepo, RoutineRepository routineRepo, TrainingRepository trainingRepo, TrainingForRoutineRepository trainingForRoutineRepo) {
        log.info("RoutineService created");
        this.requestLogRepo = requestLogRepo;
        this.routineRepo = routineRepo;
        this.trainingRepo = trainingRepo;
        this.trainingForRoutineRepo = trainingForRoutineRepo;
    }

    // 루틴 목록
    public List<ResponseRoutineDTO> getRoutines() {
        log.info("RoutineService getRoutines");
        List<Routine> routines = routineRepo.findAll();
        List<ResponseRoutineDTO> responseRoutineDTOs = new ArrayList<>();
        for (Routine routine : routines) {
            ResponseRoutineDTO responseRoutineDTO = new ResponseRoutineDTO(
                    routine.getRoutineName(),
                    routine.getUnitLength(),
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
    public List<ResponseRoutineDetailDTO> getRoutineDetail(int id) {
        log.info("RoutineService getRoutine");

        RoutineRepo.findById(id).orElse(null);
        List<ResponseRoutineDetailDTO> responseRoutineDetailDTOs = new ArrayList<>(

        );
        return null;
    }

    // 루틴 저장
    public Routine saveRoutine(RequestRoutineDTO requestRoutineDTO) {
        log.info("RoutineService saveRoutine");
        Routine routine = new Routine();
        return routineRepo.save(routine);
    }

    // 루틴 삭제
    public ResponseRoutineDTO deleteRoutine(int id) {
        log.info("RoutineService deleteRoutine");
        ResponseRoutineDTO routine = routineRepo.findById(id).orElse(null);
        routineRepo.deleteById(id);
        return routine;
    }
}
