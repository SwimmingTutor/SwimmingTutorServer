package kr.sesacjava.swimtutor.leveltest.service;

import kr.sesacjava.swimtutor.common.requestLog.RequestLogRepository;
import kr.sesacjava.swimtutor.leveltest.repository.LevelLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelLogService {

    private static final Logger log = LoggerFactory.getLogger(LevelLogService.class);

    private final LevelLogRepository levelLogRepo;
    private final RequestLogRepository requestLogRepo;

    @Autowired
    public LevelLogService(LevelLogRepository llRepo, RequestLogRepository rlRepo) {
        log.info("LevelLogService() 생성자 호출되면서 LevelLogRepository, RequestLogRepository Bean 객체가 Autowired 됨.");
        this.levelLogRepo = llRepo;
        this.requestLogRepo = rlRepo;
    }

//    public List<LevelLog> getAllLevelLog() {
//        List<LevelLog> list = levelLogRepo.findAll();
//        ;
//        requestLogRepo.save(new RequestLog(MethodType.GET, "getLevelLogs", true));
//        return list;
//    }
//
//    public LevelLog getLevelLog(int id) {
//        LevelLog ll = levelLogRepo.findById(id).orElse(null);
//        if (ll != null)
//            requestLogRepo.save(new RequestLog(MethodType.GET, String.format("getLevelLog(%s)", ll), true));
//        else
//            requestLogRepo.save(new RequestLog(MethodType.GET, String.format("getLevelLog(%s)", id), false));
//        return ll;
//    }
//
//    public LevelLog createLevelLog(LevelLog ll) {
//        LevelLog newLl = levelLogRepo.save(ll);
//        requestLogRepo.save(new RequestLog(MethodType.POST, String.format("addLevelLog(%s)", ll), true));
//        return newLl;
//    }
//
//    public LevelLog updateLevelLog(int id, LevelLog newLl) {
//        LevelLog ll = levelLogRepo.findById(id).orElse(null);
//        if (ll != null) {
//            ll.setId(newLl.getId());
//            ll.setLcTrainingName(newLl.getLcTrainingName());
//            ll.setUserLevel(newLl.getUserLevel());
//            return levelLogRepo.save(ll);
//        }
//        return null;
//    }
//
//    public LevelLog deleteLevelLog(int id) {
//        LevelLog ll = levelLogRepo.findById(id).orElse(null);
//        if (ll != null) {
//            levelLogRepo.deleteById(id);
//            requestLogRepo.save(new RequestLog(MethodType.GET, String.format("getLevelLog(%d)", id), true));
//        } else {
//            requestLogRepo.save(new RequestLog(MethodType.GET, String.format("getLevelLog(%d)", id), false));
//        }
//        return ll;
//    }
}
