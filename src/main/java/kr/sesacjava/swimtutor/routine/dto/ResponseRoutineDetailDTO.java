package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseRoutineDetailDTO {
    // Routine
    private String routineName;
    private int poolLength;
    private int targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;

    // TrainingForRoutine
    private List<ResponseTrainingForRoutineDTO> trainingsForRoutine;

    @Builder
    public ResponseRoutineDetailDTO(String routineName, int poolLength, int targetDistance, String selStrokes, LocalDateTime created, LocalDateTime updated, List<ResponseTrainingForRoutineDTO> trainingsForRoutine) {
        this.routineName = routineName;
        this.poolLength = poolLength;
        this.targetDistance = targetDistance;
        this.selStrokes = selStrokes;
        this.created = created;
        this.updated = updated;
        this.trainingsForRoutine = trainingsForRoutine;
    }
}