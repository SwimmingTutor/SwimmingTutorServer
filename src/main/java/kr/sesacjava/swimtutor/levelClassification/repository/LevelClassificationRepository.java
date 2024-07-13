package kr.sesacjava.swimtutor.levelClassification.repository;

import kr.sesacjava.swimtutor.levelClassification.entity.LevelClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelClassificationRepository extends JpaRepository<LevelClassification, Long> {
}
