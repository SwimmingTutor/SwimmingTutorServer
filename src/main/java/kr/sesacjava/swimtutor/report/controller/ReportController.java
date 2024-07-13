package kr.sesacjava.swimtutor.report.controller;

import kr.sesacjava.swimtutor.records.entity.Record;
import kr.sesacjava.swimtutor.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<List<Record>> getRecordsByOauthInfo(
            @RequestParam("oauthLoginId") String oauthLoginId,
            @RequestParam("oauthLoginPlatform") String oauthLoginPlatform
    ) {
        List<Record> records = reportService.getRecordsByOauthInfo(oauthLoginId, oauthLoginPlatform);
        return ResponseEntity.ok(records);
    }




}
