package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.TrainingForRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingForRountineRepository extends JpaRepository<TrainingForRoutine, Long> {
}
