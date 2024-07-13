package kr.sesacjava.swimtutor.record.repository;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Log4j2
@Transactional
class ExerciseRecordRepositoryTest {
    @Autowired
    ExerciseRecordRepository recordRepository;

    @Test
    @Commit
    public void testInsert() {
        ExerciseRecord exerciseRecord = ExerciseRecord.builder()
                .startTime(LocalDateTime.now())
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .category("speed")
                .value(10.0)
                .build();

        ExerciseRecord result = recordRepository.save(exerciseRecord);

        assertThat(result.getValue()).isEqualTo(exerciseRecord.getValue());
        assertThat(result.getOauthLoginId()).isEqualTo(exerciseRecord.getOauthLoginId());
        assertThat(result.getOauthLoginPlatform()).isEqualTo(exerciseRecord.getOauthLoginPlatform());
        assertThat(result.getCategory()).isEqualTo(exerciseRecord.getCategory());
        assertThat(result.getStartTime()).isEqualTo(exerciseRecord.getStartTime());
        assertThat(result.getStopTime()).isEqualTo(exerciseRecord.getStopTime());
    }

    @Test
    public void testList() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            ExerciseRecord exerciseRecord = ExerciseRecord.builder()
                    .startTime(LocalDateTime.now())
                    .oauthLoginId("abcd")
                    .oauthLoginPlatform("google")
                    .category("speed")
                    .value(i * 10.0)
                    .build();

            recordRepository.save(exerciseRecord);
        });

        List<ExerciseRecord> list = recordRepository.findAll();

        assertThat(list).hasSize(10);
        assertThat(list.get(0)).isInstanceOf(ExerciseRecord.class);

    }
}
