package kr.sesacjava.swimtutor.record.repository;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Log4j2
@Transactional
class ExerciseRecordRepositoryTest {
    @Autowired
    ExerciseRecordRepository recordRepository;

    @Test
    public void testInsert() {
        ExerciseRecord userExerciseRecord = ExerciseRecord.builder()
                .startTime(LocalDateTime.now())
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .category("speed")
                .record(10.0)
                .build();

        ExerciseRecord result = recordRepository.save(userExerciseRecord);

        assertThat(result.getRecord()).isEqualTo(userExerciseRecord.getRecord());
        assertThat(result.getOauthLoginId()).isEqualTo(userExerciseRecord.getOauthLoginId());
        assertThat(result.getOauthLoginPlatform()).isEqualTo(userExerciseRecord.getOauthLoginPlatform());
        assertThat(result.getCategory()).isEqualTo(userExerciseRecord.getCategory());
        assertThat(result.getStartTime()).isEqualTo(userExerciseRecord.getStartTime());
        assertThat(result.getStopTime()).isEqualTo(userExerciseRecord.getStopTime());
    }

    @Test
    public void testInsertDuplicateData() {
        LocalDateTime now = LocalDateTime.now();
        ExerciseRecord userExerciseRecord = ExerciseRecord.builder()
                .startTime(now)
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .category("speed")
                .record(10.0)
                .build();

        ExerciseRecord userExerciseRecord2 = ExerciseRecord.builder()
                .startTime(now)
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .category("speed")
                .record(20.0)
                .build();
        recordRepository.save(userExerciseRecord);

        assertThatThrownBy(() -> recordRepository.save(userExerciseRecord2))
                .isInstanceOf(JpaSystemException.class);
    }

    @Test
    public void testList() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            ExerciseRecord board = ExerciseRecord.builder()
                    .startTime(LocalDateTime.now())
                    .oauthLoginId("abcd")
                    .oauthLoginPlatform("google")
                    .category("speed")
                    .record(i * 10.0)
                    .build();

            recordRepository.save(board);
        });

        List<ExerciseRecord> list = recordRepository.findAll();

        assertThat(list).hasSize(10);
        assertThat(list.get(0)).isInstanceOf(ExerciseRecord.class);

    }
}
