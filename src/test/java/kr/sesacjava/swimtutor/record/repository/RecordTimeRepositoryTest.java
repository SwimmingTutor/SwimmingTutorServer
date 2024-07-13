package kr.sesacjava.swimtutor.record.repository;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.record.entity.RecordTime;
import kr.sesacjava.swimtutor.record.entity.RecordTimeId;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
@Transactional
class RecordTimeRepositoryTest {
    @Autowired
    RecordTimeRepository repository;

    @Test
    @Commit
    public void insertTest() {
        RecordTime recordTime = RecordTime.builder()
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .recordTime(LocalDateTime.now())
                .build();

        repository.save(recordTime);


    }

    @Test
    public void recordTimeTest() {
        RecordTime r = repository.findById(
                        RecordTimeId.builder()
                                .oauthLoginId("abcd")
                                .oauthLoginPlatform("google")
                                .build())
                .orElseThrow();


        log.info(r);
    }
}
