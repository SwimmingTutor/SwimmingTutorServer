package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
}
