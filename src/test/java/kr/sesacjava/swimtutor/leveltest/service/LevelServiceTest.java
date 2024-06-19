package kr.sesacjava.swimtutor.leveltest.service;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
@Transactional
class LevelServiceTest {
    @Autowired
    LevelService levelService;

    @Test
//    @Commit
    public void registerTest() {
        LevelLogDTO levelLogDTO = LevelLogDTO.builder()
                .style("자유형")
                .distance(1)
                .speed(3)
                .technique(2)
                .build();

        levelService.registerLevelLog(levelLogDTO);
    }
}
