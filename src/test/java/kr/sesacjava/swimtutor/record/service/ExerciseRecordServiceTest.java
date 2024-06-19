package kr.sesacjava.swimtutor.record.service;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Log4j2
@Transactional
class ExerciseRecordServiceTest {
    @Autowired
    ExerciseRecordService recordService;

    @Test
    public void registerTest() {
        log.info(recordService.getClass().getName());
        LocalDateTime now = LocalDateTime.now();
        ExerciseRecordDTO boardDTO = ExerciseRecordDTO.builder()
                .startTime(now)
                .stopTime(now.plusHours(1))
                .category("speed")
                .record(10.1)
                .build();

        LocalDateTime startTime = recordService.register(boardDTO);

        Assertions.assertThat(startTime).isEqualTo(now);
    }

    @Test
    public void listTest() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            LocalDateTime now = LocalDateTime.now();
            ExerciseRecordDTO boardDTO = ExerciseRecordDTO.builder()
                    .startTime(now)
                    .stopTime(now.plusHours(1))
                    .category("speed")
                    .record(i * 10.0)
                    .build();

            recordService.register(boardDTO);
        });

        List<ExerciseRecordDTO> list = recordService.list();

        assertThat(list).hasSize(10);
        assertThat(list.get(0)).isInstanceOf(ExerciseRecordDTO.class);
    }

}
