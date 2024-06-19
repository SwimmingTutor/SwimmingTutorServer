package kr.sesacjava.swimtutor.routine.repository;

import kr.sesacjava.swimtutor.routine.dto.ResponseRoutineDTO;
import kr.sesacjava.swimtutor.routine.entity.Routine;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, RoutineId> {
    Optional<ResponseRoutineDTO> findById(int id);

    void deleteById(int id);
}