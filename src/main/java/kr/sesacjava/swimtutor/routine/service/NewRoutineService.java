package kr.sesacjava.swimtutor.routine.service;

import kr.sesacjava.swimtutor.routine.dto.RequestRoutineDTO;
import kr.sesacjava.swimtutor.routine.dto.TrainingForRoutineDTO;
import kr.sesacjava.swimtutor.routine.entity.Routine;
import kr.sesacjava.swimtutor.routine.entity.Training;
import kr.sesacjava.swimtutor.security.dto.UserInfo;

import java.util.List;

public interface NewRoutineService {

    // 세션별 목표거리 계산
    int calculateDistanceForSession(int baseDistance, double sessionPercentage, double variationPercentage);

    // 세션별 선택 가능 훈련 목록 선정
    List<Training> selectAvailableTrainings(UserInfo userInfo, int sessionTargetDistance, String selStrokes);

    // 세션별 훈련 선택
    List<Training> selectTrainingsForSession(int sessionTargetDistance, List<Training> availableTrainings);

    // 루틴 상세 생성
    List<TrainingForRoutineDTO> createTrainingsForRoutine(UserInfo userInfo, int targetDistance, String selStrokes);

    // 루틴 상세 저장
    void saveTrainingsForRoutine(Routine routine, List<TrainingForRoutineDTO> trainingForRoutineDTOS);

    // 새 루틴 생성 및 저장
    List<String> saveNewRoutine(UserInfo userInfo, RequestRoutineDTO requestRoutineDTO);
}
