package kr.sesacjava.swimtutor.controller;

import kr.sesacjava.swimtutor.model.LevelLog;
import kr.sesacjava.swimtutor.service.LevelLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levelLog")
public class LevelLogController {

    @Autowired
    private LevelLogService levelLogService;

    @GetMapping
    public List<LevelLog> getAllLevelLogs() {
        return levelLogService.getAllLevelLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelLog> getLevelLogById(@PathVariable int id) {
        LevelLog levelLog = levelLogService.getLevelLogById(id);
        if (levelLog != null) {
            return ResponseEntity.ok(levelLog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public LevelLog createLevelLog(@RequestBody LevelLog levelLog) {
        return levelLogService.createLevelLog(levelLog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LevelLog> updateLevelLog(@PathVariable int id, @RequestBody LevelLog levelLog) {
        LevelLog updatedLevelLog = levelLogService.updateLevelLog(id, levelLog);
        if (updatedLevelLog != null) {
            return ResponseEntity.ok(updatedLevelLog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteLevelLog(@PathVariable int id) {
//        levelLogService.deleteLevelLog(id);
//        return ResponseEntity.noContent().build();
//    }
}
