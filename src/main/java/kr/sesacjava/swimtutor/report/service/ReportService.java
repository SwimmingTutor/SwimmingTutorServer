package kr.sesacjava.swimtutor.report.service;

import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import kr.sesacjava.swimtutor.security.dto.UserInfo;

import java.util.List;

public interface ReportService {
    List<ExerciseRecord> getRecordsByOauthInfo(UserInfo userInfo);
}
