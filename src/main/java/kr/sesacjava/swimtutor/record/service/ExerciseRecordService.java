package kr.sesacjava.swimtutor.record.service;

import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;

import java.time.LocalDateTime;
import java.util.List;


public interface ExerciseRecordService {
    public void register(List<ExerciseRecordDTO> dataDTO);

    public List<ExerciseRecordDTO> list();

    public LocalDateTime lastRecordTime();

    default ExerciseRecordDTO entityToDto(ExerciseRecord exerciseRecord) {

        return ExerciseRecordDTO.builder()
                .startTime(exerciseRecord.getStartTime())
                .stopTime(exerciseRecord.getStopTime())
                .category(exerciseRecord.getCategory())
                .value(exerciseRecord.getValue())
                .build();
    }
}
