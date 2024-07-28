package kr.sesacjava.swimtutor.leveltest.repository;

import kr.sesacjava.swimtutor.leveltest.dto.LevelResponseDTO;
import kr.sesacjava.swimtutor.leveltest.entity.Level;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LevelRepository extends JpaRepository<Level, Long> {
    // 현재 수영 레벨을 조회
    @Query("SELECT new kr.sesacjava.swimtutor.leveltest.dto.LevelResponseDTO(l.lcTrainingName, l.userLevel) " +
            "FROM Level l WHERE l.oauthLoginId = :#{#userInfo.email} AND l.oauthLoginPlatform = :#{#userInfo.platform}")
    List<LevelResponseDTO> findCurrentLevel(@Param("userInfo") UserInfo userInfo);
}
