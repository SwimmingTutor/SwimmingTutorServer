package kr.sesacjava.swimtutor.report.service;

import kr.sesacjava.swimtutor.records.entity.Record;

import java.util.List;

public interface ReportService {
    List<Record> getRecordsByOauthInfo(String oauthLoginId, String oauthLoginPlatform);
}
