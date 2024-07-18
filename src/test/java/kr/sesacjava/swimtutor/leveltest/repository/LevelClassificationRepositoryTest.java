package kr.sesacjava.swimtutor.leveltest.repository;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.leveltest.entity.LevelClassification;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
@Transactional
class LevelClassificationRepositoryTest {
    @Autowired
    LevelClassificationRepository repository;

    @Test
    public void listTest() {
        List<LevelClassification> list = repository.findAll();

        list.forEach(i -> log.info("LcTrainingName={}, userLevel={}, standardName={}, content={}",
                i.getLcTrainingName(),
                i.getUserLevel(),
                i.getStandardName(),
                i.getContent()));
    }
}
