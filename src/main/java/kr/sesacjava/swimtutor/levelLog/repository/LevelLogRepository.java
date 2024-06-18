package kr.sesacjava.swimtutor.levelLog.repository;

import kr.sesacjava.swimtutor.levelLog.entity.LevelLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelLogRepository extends JpaRepository<LevelLog, Long> {
}
