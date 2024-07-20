package kr.sesacjava.swimtutor.report.service.impl;

import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import kr.sesacjava.swimtutor.record.repository.ExerciseRecordRepository;
import kr.sesacjava.swimtutor.report.service.ReportService;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ExerciseRecordRepository recordRepository;

    @Override
    public List<ExerciseRecord> getRecordsByOauthInfo(UserInfo userInfo) {
        List<ExerciseRecord> list = recordRepository.findByEmailAndPlatform(userInfo.getEmail(), userInfo.getPlatform());
        return list;
    }
}
