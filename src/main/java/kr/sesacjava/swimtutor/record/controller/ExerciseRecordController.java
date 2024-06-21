package kr.sesacjava.swimtutor.record.controller;

import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import kr.sesacjava.swimtutor.record.service.ExerciseRecordService;
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
    public void postExerciseRecord(@RequestBody ExerciseRecordDTO exerciseRecordDTO) {
        log.info("register");
        exerciseRecordService.register(exerciseRecordDTO);
    }

//    @PostMapping("/")
//    public void postExerciseRecord(@RequestBody ExerciseRecordDTO exerciseRecordDTO) {
//        log.info("register");
//        exerciseRecordService.register(exerciseRecordDTO);
//    }

    @GetMapping("/")
    public List<ExerciseRecordDTO> getExerciseRecord() {
        return exerciseRecordService.list();
    }


    @GetMapping("/last-time")
    public LocalDateTime getLastRecordTime() {
        return exerciseRecordService.lastRecordTime();
    }

//    @GetMapping("/")
//    public LocalDateTime getLastExerciseTime() {
//
//    }
}
