package kr.sesacjava.swimtutor.record.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseRecordDTO {
    private LocalDateTime startTime;
    private LocalDateTime stopTime;
    private String category;
    private Double value;
}
