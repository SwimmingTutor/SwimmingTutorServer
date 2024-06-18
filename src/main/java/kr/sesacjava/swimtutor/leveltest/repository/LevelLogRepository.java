package kr.sesacjava.swimtutor.leveltest.repository;

import kr.sesacjava.swimtutor.leveltest.temp.LevelLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelLogRepository extends JpaRepository<LevelLog, Long> {
}
