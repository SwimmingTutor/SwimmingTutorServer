package kr.sesacjava.swimtutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.sesacjava.swimtutor.model.LevelLog;

public interface LevelLogRepository extends JpaRepository<LevelLog, Integer> {
}
