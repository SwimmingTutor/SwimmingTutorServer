package kr.sesacjava.swimtutor.service;

import kr.sesacjava.swimtutor.domain.UserExerciseRecord;
import kr.sesacjava.swimtutor.dto.UserExerciseRecordDTO;

import java.time.LocalDateTime;


public interface UserExerciseRecordService {
    public LocalDateTime register(UserExerciseRecordDTO userExerciseRecordDTO);

    default UserExerciseRecord dtoToEntity(UserExerciseRecordDTO recordDTO) {
        // TODO: oauthLoginId, oauthLoginPlatform 수정 필요
        UserExerciseRecord record = UserExerciseRecord.builder()
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .startTime(recordDTO.getStartTime())
                .stopTime(recordDTO.getStopTime())
                .category(recordDTO.getCategory())
                .record(recordDTO.getRecord())
                .build();

        return record;
    }
}
