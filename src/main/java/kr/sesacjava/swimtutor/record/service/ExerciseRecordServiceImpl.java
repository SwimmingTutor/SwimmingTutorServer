package kr.sesacjava.swimtutor.record.service;

import kr.sesacjava.swimtutor.common.exception.DuplicateKeyException;
import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecordId;
import kr.sesacjava.swimtutor.record.repository.ExerciseRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ExerciseRecordServiceImpl implements ExerciseRecordService {
    private final ExerciseRecordRepository recordRepository;

    @Override
    public void register(ExerciseRecordDTO exerciseRecordDTO) {
        // TODO: oauthLoginId, oauthLoginPlatform 수정 필요
        boolean exists = recordRepository.existsById(
                ExerciseRecordId.builder()
                        .category(exerciseRecordDTO.getCategory())
                        .startTime(exerciseRecordDTO.getStartTime())
                        .oauthLoginId("abcd")
                        .oauthLoginPlatform("google")
                        .build());

        if (exists) {
            throw new DuplicateKeyException("아이디 중복");
        }

        ExerciseRecord record = dtoToEntity(exerciseRecordDTO);

        recordRepository.save(record);
    }

    @Override
    public List<ExerciseRecordDTO> list() {
        List<ExerciseRecord> result = recordRepository.findAll();

        return result.stream()
                .map(this::entityToDto)
                .toList();
    }
}
