package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.domain.UserExerciseRecord;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
class UserExerciseRecordRepositoryTest {
    @Autowired
    UserExerciseRecordRepository userExerciseRecordRepository;

    @Test
    public void testInsert() {
        UserExerciseRecord userExerciseRecord = UserExerciseRecord.builder()
                .startTime(LocalDateTime.now())
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .category("speed")
                .record(10.0)
                .build();

        UserExerciseRecord result = userExerciseRecordRepository.save(userExerciseRecord);
        log.info("record: " + result);
    }

    @Test
    public void testInsertDuplicateData() {
        LocalDateTime now = LocalDateTime.now();
        UserExerciseRecord userExerciseRecord = UserExerciseRecord.builder()
                .startTime(now)
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .category("speed")
                .record(10.0)
                .build();

        UserExerciseRecord userExerciseRecord2 = UserExerciseRecord.builder()
                .startTime(now)
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .category("speed")
                .record(20.0)
                .build();
        userExerciseRecordRepository.save(userExerciseRecord);

        Assertions.assertThatThrownBy(() -> userExerciseRecordRepository.save(userExerciseRecord2))
                .isInstanceOf(JpaSystemException.class);
    }
}
