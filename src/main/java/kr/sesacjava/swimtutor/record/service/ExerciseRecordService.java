package kr.sesacjava.swimtutor.record.service;

import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;

import java.time.LocalDateTime;
import java.util.List;


public interface ExerciseRecordService {
    public LocalDateTime register(ExerciseRecordDTO userExerciseRecordDTO);

    public List<ExerciseRecordDTO> list();

    default ExerciseRecord dtoToEntity(ExerciseRecordDTO recordDTO) {
        // TODO: oauthLoginId, oauthLoginPlatform 수정 필요

        return ExerciseRecord.builder()
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .startTime(recordDTO.getStartTime())
                .stopTime(recordDTO.getStopTime())
                .category(recordDTO.getCategory())
                .record(recordDTO.getRecord())
                .build();
    }

    default ExerciseRecordDTO entityToDto(ExerciseRecord exerciseRecord) {

        return ExerciseRecordDTO.builder()
                .startTime(exerciseRecord.getStartTime())
                .stopTime(exerciseRecord.getStopTime())
                .category(exerciseRecord.getCategory())
                .record(exerciseRecord.getRecord())
                .build();
    }
}
