package kr.sesacjava.swimtutor.routine.repository;

import kr.sesacjava.swimtutor.routine.entity.TrainingForRoutine;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import kr.sesacjava.swimtutor.routine.entity.id.TrainingForRoutineId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingForRoutineRepository extends JpaRepository<TrainingForRoutine, TrainingForRoutineId> {
    List<TrainingForRoutine> findByRoutineId(RoutineId routineId);
}