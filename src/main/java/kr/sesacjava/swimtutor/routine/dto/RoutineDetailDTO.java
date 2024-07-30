package kr.sesacjava.swimtutor.routine.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoutineDetailDTO {
    // Routine
    private String routineName;
    private Integer poolLength;
    private Integer targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;

    // ResponseTrainingForRoutine
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_no")
    private List<TrainingForRoutineDTO> trainingData;
}