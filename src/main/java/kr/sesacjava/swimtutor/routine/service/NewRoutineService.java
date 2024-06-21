package kr.sesacjava.swimtutor.routine.service;

import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.RequestTrainingForRoutineDTO;
import kr.sesacjava.swimtutor.routine.entity.Training;

import java.util.List;

public interface NewRoutineService {

    // 세션별 목표거리 계산
    int calculateDistanceForSession(int baseDistance, double sessionPercentage, double variationPercentage);

    // 세션별 선택 가능 훈련 목록 선정
    List<Training> selectAvailableTrainings(int sessionTargetDistance, String selStrokes);

    // 세션별 훈련 선택
    List<Training> selectTrainingsForSession(int sessionTargetDistance, List<Training> availableTrainings);

    // 루틴 생성
    List<RequestTrainingForRoutineDTO> createRoutine(int targetDistance, String selStrokes);

    // 루틴 저장
    List<RequestTrainingForRoutineDTO> saveTrainingsForRoutine(RequestRoutineDTO routine);
}
