package kr.sesacjava.swimtutor.leveltest.service;

import kr.sesacjava.swimtutor.common.exception.NotFoundException;
import kr.sesacjava.swimtutor.common.requestLog.RequestLogRepository;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogDTO;
import kr.sesacjava.swimtutor.leveltest.dto.LevelLogResponseDTO;
import kr.sesacjava.swimtutor.leveltest.entity.LevelLog;
import kr.sesacjava.swimtutor.leveltest.repository.LevelClassificationRepository;
import kr.sesacjava.swimtutor.leveltest.repository.LevelLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {
    private static final Logger log = LoggerFactory.getLogger(LevelServiceImpl.class);
    private final LevelLogRepository levelLogRepository;
    private final LevelClassificationRepository levelClassificationRepository;
    private final RequestLogRepository requestLogRepository;

    //    @Autowired
    public LevelServiceImpl(LevelLogRepository llRepo,
                            RequestLogRepository rlRepo,
                            LevelClassificationRepository levelClassificationRepository) {
        log.info("LevelLogService() 생성자 호출되면서 LevelLogRepository, RequestLogRepository Bean 객체가 Autowired 됨.");
        this.levelLogRepository = llRepo;
        this.requestLogRepository = rlRepo;
        this.levelClassificationRepository = levelClassificationRepository;
    }

    @Override
    public void registerLevelLog(LevelLogDTO levelLogDTO) {
        LevelLog levelLog = levelLogDtoToEntity(levelLogDTO);

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
}
