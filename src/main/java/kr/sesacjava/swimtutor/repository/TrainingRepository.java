package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
