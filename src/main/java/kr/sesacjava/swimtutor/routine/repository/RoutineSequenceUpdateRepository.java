package kr.sesacjava.swimtutor.routine.repository;

import kr.sesacjava.swimtutor.routine.entity.RoutineSequenceUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface RoutineSequenceUpdateRepository extends JpaRepository<RoutineSequenceUpdate, Long> {
    @Procedure("process_routine_update_queue")
    void processRoutineUpdateQueue();
}
