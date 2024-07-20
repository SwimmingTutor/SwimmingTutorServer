package kr.sesacjava.swimtutor.report.controller;

import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import kr.sesacjava.swimtutor.report.service.ReportService;
import kr.sesacjava.swimtutor.security.CurrentUser;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<List<ExerciseRecord>> getRecordsByOauthInfo(@CurrentUser UserInfo userInfo) {
        List<ExerciseRecord> records = reportService.getRecordsByOauthInfo(userInfo);
        return ResponseEntity.ok(records);
    }


}
