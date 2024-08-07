package kr.sesacjava.swimtutor.record.service;

import kr.sesacjava.swimtutor.record.dto.ExerciseRecordDTO;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import kr.sesacjava.swimtutor.record.entity.RecordTime;
import kr.sesacjava.swimtutor.record.entity.RecordTimeId;
import kr.sesacjava.swimtutor.record.repository.ExerciseRecordRepository;
import kr.sesacjava.swimtutor.record.repository.RecordTimeRepository;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ExerciseRecordServiceImpl implements ExerciseRecordService {
    private final ExerciseRecordRepository recordRepository;
    private final RecordTimeRepository recordTimeRepository;

    @Override
    public void register(UserInfo userInfo, List<ExerciseRecordDTO> dataDTO) {
        List<ExerciseRecord> list = dataDTO.stream().map(data ->
                ExerciseRecord.builder()
                        .oauthLoginId(userInfo.getEmail())
                        .oauthLoginPlatform(userInfo.getPlatform())
                        .category(data.getCategory())
                        .value(data.getValue())
                        .startTime(data.getStartTime())
                        .stopTime(data.getStopTime())
                        .build()
        ).toList();

        recordRepository.saveAll(list);
    }

    @Override
    public List<ExerciseRecordDTO> list() {
        List<ExerciseRecord> result = recordRepository.findAll();

        return result.stream()
                .map(this::entityToDto)
                .toList();
    }

    @Override
    public LocalDateTime lastRecordTime() {
        RecordTimeId id = RecordTimeId.builder()
                .oauthLoginId("abcd")
                .oauthLoginPlatform("google")
                .build();
        Optional<RecordTime> result = recordTimeRepository.findById(id);

        return result.map(RecordTime::getRecordTime).orElse(null);
    }
}
