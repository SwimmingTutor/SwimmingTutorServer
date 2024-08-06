package kr.sesacjava.swimtutor.routine.repository;

import kr.sesacjava.swimtutor.routine.entity.TrainingForRoutine;
import kr.sesacjava.swimtutor.routine.entity.id.TrainingForRoutineId;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingForRoutineRepository extends JpaRepository<TrainingForRoutine, TrainingForRoutineId> {
    @Query("SELECT tfr FROM TrainingForRoutine tfr WHERE tfr.oauthLoginId = :#{#userInfo.email} AND tfr.oauthLoginPlatform = :#{#userInfo.platform} AND tfr.routineNo = :routineNo")
    List<TrainingForRoutine> findAllByRoutineNo(UserInfo userInfo, Integer routineNo);
}