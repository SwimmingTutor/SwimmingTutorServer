package kr.sesacjava.swimtutor.record.service;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.common.exception.DuplicateKeyException;
import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecordId;
import kr.sesacjava.swimtutor.record.repository.ExerciseRecordRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Log4j2
@Transactional
class ExerciseRecordServiceTest {
    @Autowired
    ExerciseRecordService recordService;

    @Autowired
    ExerciseRecordRepository recordRepository;

    @Test
    public void registerTest() {
        log.info(recordService.getClass().getName());
        LocalDateTime now = LocalDateTime.now();
        ExerciseRecordDTO exerciseRecordDTO = ExerciseRecordDTO.builder()
                .startTime(now)
                .stopTime(now.plusHours(1))
                .category("speed")
                .value(10.1)
                .build();

        recordService.register(exerciseRecordDTO);

        // TODO: oauthLoginPlatform, oauthLoginId 수정 필요
        ExerciseRecord created = recordRepository.findById(ExerciseRecordId.builder()
                .oauthLoginPlatform("google")
                .oauthLoginId("abcd")
                .category("speed")
                .startTime(now).build()).orElseThrow();

        assertThat(created.getValue()).isEqualTo(10.1);
        assertThat(created.getCategory()).isEqualTo("speed");
    }

    @Test
    public void registerDupleTest() {
        log.info(recordService.getClass().getName());
        LocalDateTime now = LocalDateTime.now();
        ExerciseRecordDTO exerciseRecordDTO = ExerciseRecordDTO.builder()
                .startTime(now)
                .stopTime(now.plusHours(1))
                .category("speed")
                .value(10.1)
                .build();

        recordService.register(exerciseRecordDTO);

        ExerciseRecordDTO exerciseRecordDTO2 = ExerciseRecordDTO.builder()
                .startTime(now)
                .stopTime(now.plusHours(1))
                .category("speed")
                .value(10.1)
                .build();

        assertThatThrownBy(() -> recordService.register(exerciseRecordDTO2))
                .isInstanceOf(DuplicateKeyException.class);
    }

    @Test
    public void listTest() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            LocalDateTime now = LocalDateTime.now();
            ExerciseRecordDTO exerciseRecordDTO = ExerciseRecordDTO.builder()
                    .startTime(now)
                    .stopTime(now.plusHours(1))
                    .category("speed")
                    .value(i * 10.0)
                    .build();

            recordService.register(exerciseRecordDTO);
        });

        List<ExerciseRecordDTO> list = recordService.list();

        assertThat(list).hasSize(10);
        assertThat(list.get(0)).isInstanceOf(ExerciseRecordDTO.class);
    }

}
