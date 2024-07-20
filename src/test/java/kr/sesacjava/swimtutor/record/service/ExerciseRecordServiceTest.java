package kr.sesacjava.swimtutor.record.service;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.record.repository.ExerciseRecordRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
@Transactional
class ExerciseRecordServiceTest {
    @Autowired
    ExerciseRecordService recordService;

    @Autowired
    ExerciseRecordRepository recordRepository;

}
