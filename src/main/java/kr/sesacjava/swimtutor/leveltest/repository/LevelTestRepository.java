package kr.sesacjava.swimtutor.leveltest.repository;

import kr.sesacjava.swimtutor.leveltest.entity.LevelLog;
import kr.sesacjava.swimtutor.leveltest.entity.oauthAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelTestRepository extends JpaRepository<LevelLog, oauthAccount> {
}
