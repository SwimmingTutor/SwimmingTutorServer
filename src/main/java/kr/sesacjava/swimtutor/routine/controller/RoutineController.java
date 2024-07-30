package kr.sesacjava.swimtutor.routine.controller;

import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.TrainingForRoutineDTO;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import kr.sesacjava.swimtutor.routine.service.NewRoutineImpl;
import kr.sesacjava.swimtutor.routine.service.RoutineImpl;
import kr.sesacjava.swimtutor.security.CurrentUser;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routine")
public class RoutineController {

    private static final Logger LOG = LoggerFactory.getLogger(RoutineController.class);
    private final NewRoutineImpl newRoutineImpl;
    private final RoutineImpl routineImpl;

    @Autowired
    public RoutineController(NewRoutineImpl newRoutineImpl, RoutineImpl routineImpl) {
        LOG.info("RoutineController 생성자 호출");
        this.newRoutineImpl = newRoutineImpl;
        this.routineImpl = routineImpl;
    }

    // 루틴 목록
    @GetMapping("/all")
    public List<ResponseRoutineDTO> getAllRoutines() {
//        LOG.info("routineService getRoutines 호출");

        return routineImpl.getAllRoutines();
    }

    // 유저별 루틴 목록 조회
    @GetMapping("/list")
    public List<ResponseRoutineDTO> getSeveralRoutines(@CurrentUser UserInfo userInfo) {
//        LOG.info("routineService getSeveralRoutines 호출");
        return routineImpl.getSeveralRoutines(userInfo);
    }

    // 루틴 상세
    @GetMapping("/{routineNo}")
    public List<TrainingForRoutineDTO> getRoutineDetail(@CurrentUser UserInfo userInfo, @PathVariable Integer routineNo) {
//        LOG.info("routineDetailService getRoutineDetail 호출");
        RoutineId routineId = new RoutineId(routineNo, userInfo.getEmail(), userInfo.getPlatform());
        return routineImpl.getRoutineDetail(routineId);
    }

    // 루틴 생성
    @PostMapping
    public void saveNewRoutine(@CurrentUser UserInfo userInfo, @RequestBody RequestRoutineDTO requestRoutineDTO) {
//        LOG.info("routineService saveTrainingsForRoutine 호출");
//        LOG.info("Received userInfo: {}", userInfo.toString());
//        LOG.info("Received requestRoutineDTO: {}", requestRoutineDTO.toString());
        newRoutineImpl.saveNewRoutine(userInfo, requestRoutineDTO);
    }
}
