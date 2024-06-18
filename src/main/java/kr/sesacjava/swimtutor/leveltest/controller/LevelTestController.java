package kr.sesacjava.swimtutor.leveltest.controller;

import kr.sesacjava.swimtutor.leveltest.service.LevelTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelTestController {

    private final LevelTestService levelTestService;

    private static final Logger log = LoggerFactory.getLogger(LevelLogController.class);

    public LevelTestController(LevelTestService levelTestService) {
        log.info("LevelTestController instantiated");
        this.levelTestService = levelTestService;
    }
}
