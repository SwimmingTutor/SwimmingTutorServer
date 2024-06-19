package kr.sesacjava.swimtutor.leveltest.controller;

import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import kr.sesacjava.swimtutor.leveltest.service.LevelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/level")
public class LevelController {
    private final LevelService levelService;

    @PostMapping("/log")
    public void levelLog(@RequestBody LevelLogDTO levelLogDTO) {
        levelService.registerLevelLog(levelLogDTO);
    }
}
