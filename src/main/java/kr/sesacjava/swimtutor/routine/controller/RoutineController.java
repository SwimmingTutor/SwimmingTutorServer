package kr.sesacjava.swimtutor.routine.controller;

import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDetailDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseTrainingForRoutineDTO;
import kr.sesacjava.swimtutor.routine.service.NewRoutineService;
import kr.sesacjava.swimtutor.routine.service.RoutineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routine")
public class RoutineController {

    private static final Logger log = LoggerFactory.getLogger(RoutineController.class);
    private NewRoutineService newRoutineService;
    private RoutineService routineService;

    @Autowired
    public RoutineController(NewRoutineService newRoutineService, RoutineService routineService) {
        log.info("RoutineController created");
        this.newRoutineService = newRoutineService;
        this.routineService = routineService;
    }

    @GetMapping
    public List<ResponseRoutineDTO> getRoutine() {
        log.info("routineService getRoutine");
        return routineService.getRoutines();
    }

    @GetMapping("/{routine_id}")
    public List<ResponseRoutineDetailDTO> getRoutineDetail(@PathVariable int routine_id) {
        log.info("routineDetailService getRoutineDetail");
        return routineService.getRoutineDetail(routine_id);
    }

    @PostMapping
    public List<ResponseTrainingForRoutineDTO> saveTrainingsForRoutine(RequestRoutineDTO routine) {
        log.info("routineService saveTrainingsForRoutine");
        return newRoutineService.saveTrainingsForRoutine(routine);
    }
}
