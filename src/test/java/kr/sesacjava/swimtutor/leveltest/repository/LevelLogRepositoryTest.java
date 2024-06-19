package kr.sesacjava.swimtutor.leveltest.repository;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.leveltest.entity.LevelLog;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Log4j2
@Transactional
class LevelLogRepositoryTest {
    @Autowired
    LevelLogRepository levelLogRepository;

    @Test
    // 데이터 insert 확인 하려면 commit 주석 해제
//    @Commit
    public void registerTest() {
        LevelLog levelLog = LevelLog.builder()
                .userLevel("중급")
                .lcTrainingName("자유형")
                .oauthLoginId("user1@gmail.com")
                .oauthLoginPlatform("google")
                .build();

        long levelLogId = levelLogRepository.save(levelLog).getLevelLogId();
        LevelLog created = levelLogRepository.findById(levelLogId).orElseThrow();

        assertThat(created.getLevelLogId()).isEqualTo(levelLogId);
        assertThat(created.getUserLevel()).isEqualTo("중급");
        assertThat(created.getLcTrainingName()).isEqualTo("자유형");
    }

}
