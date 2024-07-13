package kr.sesacjava.swimtutor.routine.repository;

import kr.sesacjava.swimtutor.routine.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, String> {
}