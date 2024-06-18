package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.LevelClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelClassificationRepository extends JpaRepository<LevelClassification, Long> {
}
