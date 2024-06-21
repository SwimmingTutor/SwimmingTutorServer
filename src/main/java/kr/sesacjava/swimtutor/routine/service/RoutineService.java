package kr.sesacjava.swimtutor.routine.service;

import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDetailDTO;
import kr.sesacjava.swimtutor.routine.entity.Routine;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;

import java.util.List;

public interface RoutineService {

    // 루틴 목록
    List<ResponseRoutineDTO> getRoutines();

    // 루틴 상세
    ResponseRoutineDetailDTO getRoutineDetail(RoutineId routineId);

    // 루틴 저장
    Routine saveRoutine(RequestRoutineDTO requestRoutineDTO);

    // 루틴 삭제
    Routine deleteRoutine(RoutineId routineId);
}
