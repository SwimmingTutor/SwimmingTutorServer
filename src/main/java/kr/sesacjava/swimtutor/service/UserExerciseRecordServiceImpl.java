package kr.sesacjava.swimtutor.service;

import kr.sesacjava.swimtutor.domain.UserExerciseRecord;
import kr.sesacjava.swimtutor.dto.UserExerciseRecordDTO;
import kr.sesacjava.swimtutor.repository.UserExerciseRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserExerciseRecordServiceImpl implements UserExerciseRecordService {
    private final UserExerciseRecordRepository recordRepository;

    @Override
    public LocalDateTime register(UserExerciseRecordDTO userExerciseRecordDTO) {
        UserExerciseRecord record = dtoToEntity(userExerciseRecordDTO);

        LocalDateTime startTime = recordRepository.save(record).getStartTime();

        return startTime;
    }
}
