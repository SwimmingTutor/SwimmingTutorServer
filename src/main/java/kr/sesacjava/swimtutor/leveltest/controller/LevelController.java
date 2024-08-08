package kr.sesacjava.swimtutor.leveltest.controller;

import kr.sesacjava.swimtutor.leveltest.dto.LevelDTO;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import kr.sesacjava.swimtutor.leveltest.dto.LevelResponseDTO;
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

    // 현재 수영 레벨 조회
    @GetMapping
    public List<LevelResponseDTO> getCurrentLevel(@CurrentUser UserInfo userInfo) {
        return levelService.getCurrentLevel(userInfo);
    }

    @PostMapping("/log")
    public void createLevelLog(@CurrentUser UserInfo userInfo, @RequestBody LevelDTO levelDTO) {
        levelService.registerLevelLog(userInfo, levelDTO);
    }

    @GetMapping("/log")
    public List<LevelResponseDTO> getAllLevelLog() {
        return levelService.getAllLevelLog();
    }

    @GetMapping("/log/{id}")
    public LevelResponseDTO getOneLevelLog(@PathVariable Long id) {
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
