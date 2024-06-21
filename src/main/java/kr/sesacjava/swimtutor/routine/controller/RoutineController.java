package kr.sesacjava.swimtutor.routine.controller;

import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.RequestTrainingForRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDetailDTO;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import kr.sesacjava.swimtutor.routine.service.NewRoutineImpl;
import kr.sesacjava.swimtutor.routine.service.RoutineImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routine")
public class RoutineController {

    private static final Logger log = LoggerFactory.getLogger(RoutineController.class);
    private NewRoutineImpl newRoutineImpl;
    private RoutineImpl routineImpl;

    @Autowired
    public RoutineController(NewRoutineImpl newRoutineImpl, RoutineImpl routineImpl) {
        log.info("RoutineController created");
        this.newRoutineImpl = newRoutineImpl;
        this.routineImpl = routineImpl;
    }

    // 루틴 목록
    @GetMapping
    public List<ResponseRoutineDTO> getRoutine() {
        log.info("routineService getRoutine");
        return routineImpl.getRoutines();
    }

    // 루틴 상세
    @GetMapping("/{routineNo}")
    public ResponseRoutineDetailDTO getRoutineDetail(@PathVariable int routineNo, @RequestParam String oauthLoginId, @RequestParam String oauthLoginPlatform) {
        log.info("routineDetailService getRoutineDetail");
        RoutineId routineId = new RoutineId(routineNo, oauthLoginId, oauthLoginPlatform);
        return routineImpl.getRoutineDetail(routineId);
    }

    // 루틴 생성
    @PostMapping
    public List<RequestTrainingForRoutineDTO> saveTrainingsForRoutine(@RequestBody RequestRoutineDTO routine) {
        log.info("routineService saveTrainingsForRoutine");
        return newRoutineImpl.saveTrainingsForRoutine(routine);
    }
}
