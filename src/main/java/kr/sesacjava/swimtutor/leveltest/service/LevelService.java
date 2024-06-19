package kr.sesacjava.swimtutor.leveltest.service;

import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import kr.sesacjava.swimtutor.leveltest.entity.LevelLog;

public interface LevelService {
    public void registerLevelLog(LevelLogDTO levelLogDTO);

    default LevelLog levelLogDtoToEntity(LevelLogDTO levelLogDTO) {
        LevelLog levelLog = LevelLog.builder()
                .userLevel(levelLogDTO.getUserLevel())
                .lcTrainingName(levelLogDTO.getStyle())
                .oauthLoginId("user1@gmail.com")
                .oauthLoginPlatform("google")
                .build();

        return levelLog;
    }
}
