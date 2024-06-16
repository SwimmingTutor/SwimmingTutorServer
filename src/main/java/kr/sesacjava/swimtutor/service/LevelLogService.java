package kr.sesacjava.swimtutor.service;

import kr.sesacjava.swimtutor.model.LevelLog;
import kr.sesacjava.swimtutor.model.MethodType;
import kr.sesacjava.swimtutor.model.RequestLog;
import kr.sesacjava.swimtutor.repository.LevelLogRepository;
import kr.sesacjava.swimtutor.repository.RequestLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelLogService {

    private static final Logger log = LoggerFactory.getLogger(LevelLogService.class);

    private LevelLogRepository levelLogRepo;
    private RequestLogRepository requestLogRepo;

    @Autowired
    public LevelLogService(LevelLogRepository levelLogRepo, RequestLogRepository requestLogRepo) {
        log.info("LevelLogService() 생성자 호출되면서 LevelLogRepository, RequestLogRepository Bean 객체가 Autowired 됨.");
        this.levelLogRepo = levelLogRepo;
        this.requestLogRepo = requestLogRepo;
    }

    public List<LevelLog> getLevelLogs() {
        List<LevelLog> list = levelLogRepo.findAll();;
        requestLogRepo.save(new RequestLog(MethodType.GET, "getLevelLogs", true));
        return list;
    }

    public LevelLog getLevelLog(int id) {
        Optional<LevelLog> option = levelLogRepo.findById(id);
        LevelLog ll = option.get();
        if (ll != null)
            requestLogRepo.save(new RequestLog(MethodType.GET, String.format("getLevelLog(%s)", ll), true));
        else
            requestLogRepo.save(new RequestLog(MethodType.GET, String.format("getLevelLog(%d)", id), false));
        return ll;
    }

    public LevelLog createLevelLog(LevelLog ll) {
        LevelLog newll = levelLogRepo.save(ll);
        requestLogRepo.save(new RequestLog(MethodType.POST, String.format("addLevelLog(%s)", ll), true));
        return newll;
    }

    public LevelLog updateLevelLog(int id, LevelLog newll) {
        LevelLog ll = levelLogRepo.findById(id).orElse(null);
        if (ll != null) {
            ll.setOauthLoginId(newll.getOauthLoginId());
            ll.setOauthLoginPlatform(newll.getOauthLoginPlatform());
            ll.setLcTrainingName(newll.getLcTrainingName());
            ll.setUserLevel(newll.getUserLevel());
            return levelLogRepo.save(ll);
        }
        return null;
    }

    public LevelLog deleteLevelLog(int id) {
        LevelLog ll = levelLogRepo.findById(id).orElse(null);
        if (ll != null) {
            levelLogRepo.deleteById(id);
            requestLogRepo.save(new RequestLog(MethodType.GET, String.format("getLevelLog(%d)", id), true));
        }
        else {
            requestLogRepo.save(new RequestLog(MethodType.GET, String.format("getLevelLog(%d)", id), false));
        }
        return ll;
    }
}
