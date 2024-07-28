package kr.sesacjava.swimtutor.leveltest.service;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.leveltest.dto.LevelResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
@Transactional
class LevelServiceTest {
    @Autowired
    LevelService levelService;


    @Test
    public void listTest() {
        List<LevelResponseDTO> list = levelService.getAllLevelLog();

        list.forEach(i -> log.info("lc={}, userLevel={}", i.getLcTrainingName(), i.getUserLevel()));
    }
}
