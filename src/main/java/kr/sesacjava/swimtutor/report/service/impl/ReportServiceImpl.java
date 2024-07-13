package kr.sesacjava.swimtutor.report.service.impl;

import kr.sesacjava.swimtutor.records.entity.Record;
import kr.sesacjava.swimtutor.report.repository.ReportRepository;
import kr.sesacjava.swimtutor.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public List<Record> getRecordsByOauthInfo(String oauthLoginId, String oauthLoginPlatform) {
        return reportRepository.findByRecordId_OauthLoginIdAndRecordId_OauthLoginPlatform(oauthLoginId, oauthLoginPlatform);
    }
}
