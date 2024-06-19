package kr.sesacjava.swimtutor.record.service;

import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import kr.sesacjava.swimtutor.record.repository.ExerciseRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ExerciseRecordServiceImpl implements ExerciseRecordService {
    private final ExerciseRecordRepository recordRepository;

    @Override
    public LocalDateTime register(ExerciseRecordDTO userExerciseRecordDTO) {
        ExerciseRecord record = dtoToEntity(userExerciseRecordDTO);

        LocalDateTime startTime = recordRepository.save(record).getStartTime();

        return startTime;
    }

    @Override
    public List<ExerciseRecordDTO> list() {
        List<ExerciseRecord> result = recordRepository.findAll();

        return result.stream()
                .map(this::entityToDto)
                .toList();
    }
}
