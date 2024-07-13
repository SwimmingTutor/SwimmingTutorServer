//package kr.sesacjava.swimtutor.leveltest.service;
//
//import kr.sesacjava.swimtutor.leveltest.entity.LevelClassification;
//import kr.sesacjava.swimtutor.leveltest.entity.UserLevel;
//import kr.sesacjava.swimtutor.leveltest.repository.LevelTestRepository;
//import kr.sesacjava.swimtutor.leveltest.repository.RequestLogRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LevelTestService {
//
//    private static final Logger log = LoggerFactory.getLogger(LevelTestService.class);
//
//    private final LevelTestRepository levelTestRepo;
//    private final RequestLogRepository requestLogRepo;
//
//    @Autowired
//    public LevelTestService(LevelTestRepository levelTestRepo, RequestLogRepository requestLogRepo) {
//        log.info("LevelTestService constructor & LevelTestDataRepo, RequestLogRepo Bean 객체 Autowired");
//        this.levelTestRepo = levelTestRepo;
//        this.requestLogRepo = requestLogRepo;
//    }
//
//    // getters
//    public LevelTestRepository getLevelTestRepo() {
//        return levelTestRepo;
//    }
//
//    public RequestLogRepository getRequestLogRepo() {
//        return requestLogRepo;
//    }
//
//    // 테스트 데이터 기반으로 휴식없이 30분 내 완주 가능 거리 레벨 평가
//    public UserLevel evalDistanceLevel(LevelClassification levelClassification) {
//        switch (levelClassification.getLcTrainingName()) {
//            case "자유형":
//                switch (levelClassification.getContent()) {
//                    case "400m 미만":
//                        return UserLevel.초급;
//                    case "800m 미만":
//                        return UserLevel.중급;
//                    case "800m 이상":
//                        return UserLevel.상급;
//                }
//                break;
//            case "배영":
//                switch (levelClassification.getContent()) {
//                    case "300m 미만":
//                        return UserLevel.초급;
//                    case "500m 미만":
//                        return UserLevel.중급;
//                    case "500m 이상":
//                        return UserLevel.상급;
//                }
//                break;
//            case "평영":
//                switch (levelClassification.getContent()) {
//                    case "300m 미만":
//                        return UserLevel.초급;
//                    case "500m 미만":
//                        return UserLevel.중급;
//                    case "500m 이상":
//                        return UserLevel.상급;
//                }
//                break;
//            case "접영":
//                switch (levelClassification.getContent()) {
//                    case "100m 미만":
//                        return UserLevel.초급;
//                    case "300m 미만":
//                        return UserLevel.중급;
//                    case "300m 이상":
//                        return UserLevel.상급;
//                }
//                break;
//        }
//        return null;
//    }
//
//    // 테스트 데이터 기반으로 50m 완주 속도 레벨 평가
//    public UserLevel evalSpeedLevel(LevelClassification levelClassification) {
//        switch (levelClassification.getLcTrainingName()) {
//            case "자유형":
//                switch (levelClassification.getContent()) {
//                    case "1분 이상":
//                        return UserLevel.초급;
//                    case "1분 미만":
//                        return UserLevel.중급;
//                    case "45초 미만":
//                        return UserLevel.상급;
//                }
//                break;
//            case "배영":
//                switch (levelClassification.getContent()) {
//                    case "1분 15초 이상":
//                        return UserLevel.초급;
//                    case "1분 15초 미만":
//                        return UserLevel.중급;
//                    case "55초 미만":
//                        return UserLevel.상급;
//                }
//                break;
//            case "평영":
//                switch (levelClassification.getContent()) {
//                    case "1분 20초 이상":
//                        return UserLevel.초급;
//                    case "1분 20초 미만":
//                        return UserLevel.중급;
//                    case "1분 미만":
//                        return UserLevel.상급;
//                }
//                break;
//            case "접영":
//                switch (levelClassification.getContent()) {
//                    case "1분 10초 이상":
//                        return UserLevel.초급;
//                    case "1분 10초 미만":
//                        return UserLevel.중급;
//                    case "50초 미만":
//                        return UserLevel.상급;
//                }
//                break;
//        }
//        return null;
//    }
//
//    // 테스트 데이터 기반으로 기술 레벨 평가
//    public UserLevel evalTechniqueLevel(LevelClassification levelClassification) {
//
//        switch (levelClassification.getLcTrainingName()) {
//            case "자유형":
//                switch (levelClassification.getContent()) {
//                    case "턴 동작을 배우지 않았다.":
//                        return UserLevel.초급;
//                    case "사이드 턴을 할 수 있다.":
//                        return UserLevel.중급;
//                    case "플립 턴을 할 수 있다.":
//                        return UserLevel.상급;
//                }
//                break;
//            case "배영":
//                switch (levelClassification.getContent()) {
//                    case "물 속 스타트를 배우지 않았다.":
//                        return UserLevel.초급;
//                    case "바사로킥 및 물 속 스타트를 할 수 있다.":
//                        return UserLevel.중급;
//                    case "배영 턴을 할 수 있다.":
//                        return UserLevel.상급;
//                }
//                break;
//            case "평영":
//                switch (levelClassification.getContent()) {
//                    case "물 속 스타트를 배우지 않았다.":
//                        return UserLevel.초급;
//                    case "두 손으로 벽을 잡고 턴 한 후, 물 속 스타트를 할 수 있다.":
//                        return UserLevel.중급;
//                    case "평영 대시를 할 수 있다.":
//                        return UserLevel.상급;
//                }
//                break;
//            case "접영":
//                switch (levelClassification.getContent()) {
//                    case "양팔 접영을 할 수 있다.":
//                        return UserLevel.초급;
//                    case "2번 팔 동작 후 1번 호흡 패턴을 유지할 수 있다.":
//                        return UserLevel.중급;
//                    case "장비없이 무호흡으로 접영 25m를 완주할 수 있다.":
//                        return UserLevel.상급;
//                }
//                break;
//        }
//        return null;
//    }
//}
