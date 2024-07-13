package kr.sesacjava.swimtutor.trainingForRoutine.repository;

import kr.sesacjava.swimtutor.training.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
