package kr.sesacjava.swimtutor.leveltest.repository;

import kr.sesacjava.swimtutor.leveltest.entity.LevelClassification;
import kr.sesacjava.swimtutor.leveltest.entity.id.LevelClassificationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelClassificationRepository extends JpaRepository<LevelClassification, LevelClassificationId> {
    
}
