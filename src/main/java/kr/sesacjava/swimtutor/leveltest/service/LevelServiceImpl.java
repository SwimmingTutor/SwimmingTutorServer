package kr.sesacjava.swimtutor.leveltest.service;

import kr.sesacjava.swimtutor.common.exception.NotFoundException;
import kr.sesacjava.swimtutor.common.requestLog.RequestLogRepository;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogResponseDTO;
import kr.sesacjava.swimtutor.leveltest.entity.LevelLog;
import kr.sesacjava.swimtutor.leveltest.repository.LevelClassificationRepository;
import kr.sesacjava.swimtutor.leveltest.repository.LevelLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class LevelServiceImpl implements LevelService {
    
    private final LevelLogRepository levelLogRepository;
    private final LevelClassificationRepository levelClassificationRepository;
    private final RequestLogRepository requestLogRepository;

    @Override
    public void registerLevelLog(LevelLogDTO levelLogDTO) {
        LevelLog levelLog = levelLogDtoToEntity(levelLogDTO, userLevel(levelLogDTO));

        levelLogRepository.save(levelLog);
    }

    @Override
    public List<LevelLogResponseDTO> getAllLevelLog() {
        List<LevelLog> list = levelLogRepository.findAll();

        List<LevelLogResponseDTO> dtoList = list.stream().map(this::levelLogEntityToDto).toList();
        return dtoList;
    }

    @Override
    public LevelLogResponseDTO getLevelLog(Long id) {
        LevelLog levelLog = levelLogRepository.findById(id).orElse(null);

        if (levelLog == null) {
            throw new NotFoundException("데이터 없음");
        }

        return levelLogEntityToDto(levelLog);
    }

    private String userLevel(LevelLogDTO levelLogDTO) {
        int total = levelLogDTO.getDistance() + levelLogDTO.getSpeed() + levelLogDTO.getTechnique();

        if (total >= 7) return "상급";
        if (total >= 4) return "중급";
        return "초급";
    }
}
