package kr.sesacjava.swimtutor.record.controller;

import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import kr.sesacjava.swimtutor.record.dto.RecordDataDTO;
import kr.sesacjava.swimtutor.record.service.ExerciseRecordService;
import kr.sesacjava.swimtutor.security.CurrentUser;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("record")
@RequiredArgsConstructor
public class ExerciseRecordController {
    private final ExerciseRecordService exerciseRecordService;

    @PostMapping("/")
    public void postExerciseRecord(@CurrentUser UserInfo userInfo, @RequestBody RecordDataDTO dataDTO) {
        exerciseRecordService.register(userInfo, dataDTO.getData());
    }

    @PostMapping("/test")
    public void postExerciseRecord(@RequestBody RecordDataDTO dataDTO) {
        UserInfo userInfo = new UserInfo("test01@gmail.com", "google");
        exerciseRecordService.register(userInfo, dataDTO.getData());
    }

    @GetMapping("/")
    public List<ExerciseRecordDTO> getExerciseRecord() {
        return exerciseRecordService.list();
    }


    @GetMapping("/last-time")
    public LocalDateTime getLastRecordTime() {
        return exerciseRecordService.lastRecordTime();
    }
}
