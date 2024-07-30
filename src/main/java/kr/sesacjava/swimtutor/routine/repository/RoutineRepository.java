package kr.sesacjava.swimtutor.routine.repository;

import kr.sesacjava.swimtutor.routine.entity.Routine;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, RoutineId> {
    // 루틴 번호 최대값 조회 - 복합키는 IDENITITY 전략 사용 불가
    @Query("SELECT MAX(r.routineNo) FROM Routine r WHERE r.oauthLoginId = :#{#userInfo.email} AND r.oauthLoginPlatform = :#{#userInfo.platform}")
    Integer findMaxRoutineNo(UserInfo userInfo);

    // 유저별 루틴 조회
    @Query("SELECT r FROM Routine r WHERE r.oauthLoginId = :#{#userInfo.email} AND r.oauthLoginPlatform = :#{#userInfo.platform}")
    List<Routine> findByUser(UserInfo userInfo);
}