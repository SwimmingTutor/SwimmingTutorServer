package kr.sesacjava.swimtutor.leveltest.controller;

import kr.sesacjava.swimtutor.leveltest.entity.LevelLog;
import kr.sesacjava.swimtutor.leveltest.service.LevelLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level_log")
public class LevelLogController {

    private final LevelLogService levelLogService;

    private static final Logger log = LoggerFactory.getLogger(LevelLogController.class);

    public LevelLogController(LevelLogService levelLogService) {
        log.info("LevelLogController");
        this.levelLogService = levelLogService;
    }

    @GetMapping
    public List<LevelLog> getLevelLogs() {
        log.info("LevelLogService getLevelLogs");
        return levelLogService.getAllLevelLog();
    }

    @GetMapping("/{id}")
    public LevelLog getLevelLog(@PathVariable int id) {
        log.info("LevelLogService getLevelLog");
        return levelLogService.getLevelLog(id);
    }

    @PostMapping
    public LevelLog createLevelLog(@RequestBody LevelLog levelLog) {
        log.info("LevelLogService createLevelLog");
        return levelLogService.createLevelLog(levelLog);
    }

//    @PutMapping
//    public LevelLog updateLevelLog(@PathVariable int id, @RequestBody LevelLog ll) {
//        log.info("LevelLogService updateLevelLog");
//        return levelLogService.updateLevelLog(id, ll);
//    }
//
//    @DeleteMapping("/{id}")
//    public LevelLog deleteLevelLog(@PathVariable int id) {
//        log.info("LevelLogService deleteLevelLog");
//        return levelLogService.deleteLevelLog(id);
//    }

}
