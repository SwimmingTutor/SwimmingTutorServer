package kr.sesacjava.swimtutor.routine.repository;

import kr.sesacjava.swimtutor.routine.entity.Routine;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, RoutineId> {
    // 루틴 번호 최대값 조회 - 복합키는 IDENITITY 전략 사용 불가
    @Query("SELECT MAX(r.routineId) FROM Routine r")
    int findMaxRoutineId();
}