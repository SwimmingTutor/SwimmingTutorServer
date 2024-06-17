package kr.sesacjava.swimtutor.service;

import kr.sesacjava.swimtutor.dto.UserExerciseRecordDTO;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
class UserExerciseRecordServiceTest {
    @Autowired
    UserExerciseRecordService userExerciseRecordService;

    @Test
    public void registerTest() {
        log.info(userExerciseRecordService.getClass().getName());
        LocalDateTime now = LocalDateTime.now();
        UserExerciseRecordDTO boardDTO = UserExerciseRecordDTO.builder()
                .startTime(now)
                .stopTime(now.plusHours(1))
                .category("speed")
                .record(10.1)
                .build();

        LocalDateTime startTime = userExerciseRecordService.register(boardDTO);

        Assertions.assertThat(startTime).isEqualTo(now);
    }


}
