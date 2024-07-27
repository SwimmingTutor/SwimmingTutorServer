package kr.sesacjava.swimtutor.leveltest.controller;

import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogResponseDTO;
import kr.sesacjava.swimtutor.leveltest.service.LevelService;
import kr.sesacjava.swimtutor.security.CurrentUser;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/level")
public class LevelController {
    private final LevelService levelService;

    @PostMapping("/log")
    public void createLevelLog(@CurrentUser UserInfo userInfo, @RequestBody LevelLogDTO levelLogDTO) {
        levelService.registerLevelLog(userInfo, levelLogDTO);
    }

    @GetMapping("/log")
    public List<LevelLogResponseDTO> getAllLevelLog() {
        return levelService.getAllLevelLog();
    }

    @GetMapping("/log/{id}")
    public LevelLogResponseDTO getOneLevelLog(@PathVariable Long id) {
        return levelService.getLevelLog(id);
    }

    @PutMapping("/log/{id}")
    public void updateLevelLog(@RequestBody LevelLogDTO levelLogDTO,
                               @PathVariable Long id) {
        levelService.updateLevelLog(levelLogDTO, id);
    }

    @DeleteMapping("/log/{id}")
    public void removeLevelLog(@PathVariable Long id) {
        levelService.remove(id);
    }
}
