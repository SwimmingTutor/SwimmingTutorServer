package kr.sesacjava.swimtutor.controller;

import kr.sesacjava.swimtutor.model.LevelLog;
import kr.sesacjava.swimtutor.service.LevelLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LevelLogController {

    private LevelLogService levelLogService;

    private static final Logger log = LoggerFactory.getLogger(LevelLogController.class);

    public LevelLogController(LevelLogService levelLogService) {
        log.info("LevelLogController");
        this.levelLogService = levelLogService;
    }

    @Autowired
    public void setLevelLogService(LevelLogService levelLogService) {
        this.levelLogService = levelLogService;
        log.info("LevelLogService set");
    }

    @GetMapping("level_log")
    public List<LevelLog> getLevelLogs() {
        log.info("LevelLogService getLevelLogs");
        return levelLogService.getLevelLogs();
    }

    @GetMapping("/level_log/{id}")
    public LevelLog getLevelLog(@PathVariable int id) {
        log.info("LevelLogService getLevelLog");
        return levelLogService.getLevelLog(id);
    }

    @PostMapping("/level_log")
    public LevelLog createLevelLog(@RequestBody LevelLog levelLog) {
        log.info("LevelLogService createLevelLog");
        return levelLogService.createLevelLog(levelLog);
    }

//    @PutMapping("/level_log")
//    public LevelLog updateLevelLog(@PathVariable int id, @RequestBody LevelLog ll) {
//        log.info("LevelLogService updateLevelLog");
//        return levelLogService.updateLevelLog(id, ll);
//    }
//
//    @DeleteMapping("/level_log/{id}")
//    public LevelLog deleteLevelLog(@PathVariable int id) {
//        log.info("LevelLogService deleteLevelLog");
//        return levelLogService.deleteLevelLog(id);
//    }

}
