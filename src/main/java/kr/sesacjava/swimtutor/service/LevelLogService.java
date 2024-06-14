package kr.sesacjava.swimtutor.service;

import kr.sesacjava.swimtutor.model.LevelLog;
import kr.sesacjava.swimtutor.repository.LevelLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelLogService {

    @Autowired
    private LevelLogRepository levelLogRepository;

    public List<LevelLog> getAllLevelLogs() {
        return levelLogRepository.findAll();
    }

    public LevelLog getLevelLogById(int id) {
        return levelLogRepository.findById(id).orElse(null);
    }

    public LevelLog createLevelLog(LevelLog levelLog) {
        return levelLogRepository.save(levelLog);
    }

    public LevelLog updateLevelLog(int id, LevelLog levelLog) {
        LevelLog existingLevelLog = levelLogRepository.findById(id).orElse(null);
        if (existingLevelLog != null) {
            existingLevelLog.setLoginId(levelLog.getLoginId());
            existingLevelLog.setPlatform(levelLog.getPlatform());
            existingLevelLog.setTrainingName(levelLog.getTrainingName());
            existingLevelLog.setUserLevel(levelLog.getUserLevel());
            return levelLogRepository.save(existingLevelLog);
        }
        return null;
    }

//    public void deleteLevelLog(int id) {
//        levelLogRepository.deleteById(id);
//    }
}
