package kr.sesacjava.swimtutor.levelClassification.controller;

import kr.sesacjava.swimtutor.levelClassification.entity.LevelClassification;
import kr.sesacjava.swimtutor.levelClassification.service.LevelClassificationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/")
@Log4j2
public class LevelClassificationController {
    @Autowired
    private LevelClassificationService levelClassificationService;

    @GetMapping("/")
    public List<LevelClassification> getLevelClassification() {
        List<LevelClassification> levels = levelClassificationService.findAll();
        for(LevelClassification level:levels){
            log.info("Level Classification: {}", level.toString());
        }
        return levels;
    }
}