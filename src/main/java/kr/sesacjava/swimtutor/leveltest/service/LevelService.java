package kr.sesacjava.swimtutor.leveltest.service;

import kr.sesacjava.swimtutor.leveltest.dto.LevelDTO;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import kr.sesacjava.swimtutor.leveltest.dto.LevelResponseDTO;
import kr.sesacjava.swimtutor.leveltest.entity.LevelLog;
import kr.sesacjava.swimtutor.security.dto.UserInfo;

import java.util.List;

public interface LevelService {

    //
    public void registerLevelLog(UserInfo userInfo, LevelDTO levelDTO);

//    public void registerLevelLog(UserInfo userInfo, LevelLogDTO levelLogDTO);

    // 현재 수영 레벨 조회
    public List<LevelResponseDTO> getCurrentLevel(UserInfo userInfo);

    public List<LevelResponseDTO> getAllLevelLog();

    public LevelResponseDTO getLevelLog(Long id);

    public void updateLevelLog(LevelLogDTO levelLogDTO, Long id);

    public void remove(Long id);

    default LevelLog levelLogDtoToEntity(UserInfo userInfo, LevelLogDTO levelLogDTO, String userLevel) {
        LevelLog levelLog = LevelLog.builder()
                .userLevel(userLevel)
                .lcTrainingName(levelLogDTO.getStyle())
                .oauthLoginId(userInfo.getEmail())
                .oauthLoginPlatform(userInfo.getPlatform())
                .build();

        return levelLog;
    }

    default LevelResponseDTO levelLogEntityToDto(LevelLog levelLog) {
        LevelResponseDTO levelResponseDTO = LevelResponseDTO.builder()
                .lcTrainingName(levelLog.getLcTrainingName())
                .userLevel(levelLog.getUserLevel())
                .build();

        return levelResponseDTO;
    }

}
