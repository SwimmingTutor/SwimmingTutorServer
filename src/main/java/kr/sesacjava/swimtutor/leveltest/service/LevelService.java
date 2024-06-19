package kr.sesacjava.swimtutor.leveltest.service;

import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogResponseDTO;
import kr.sesacjava.swimtutor.leveltest.entity.LevelLog;

import java.util.List;

public interface LevelService {
    public void registerLevelLog(LevelLogDTO levelLogDTO);

    public List<LevelLogResponseDTO> getAllLevelLog();

    public LevelLogResponseDTO getLevelLog(Long id);

    default LevelLog levelLogDtoToEntity(LevelLogDTO levelLogDTO) {
        LevelLog levelLog = LevelLog.builder()
                .userLevel(levelLogDTO.getUserLevel())
                .lcTrainingName(levelLogDTO.getStyle())
                .oauthLoginId("user1@gmail.com")
                .oauthLoginPlatform("google")
                .build();

        return levelLog;
    }

    default LevelLogResponseDTO levelLogEntityToDto(LevelLog levelLog) {
        LevelLogResponseDTO levelLogResponseDTO = LevelLogResponseDTO.builder()
                .lcTrainingName(levelLog.getLcTrainingName())
                .userLevel(levelLog.getUserLevel())
                .build();

        return levelLogResponseDTO;
    }


}
