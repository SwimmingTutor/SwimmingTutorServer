package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRoutineDetailDTO {
    // Routine
    private String routineName;
    private int unitLength;
    private int targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;

    // TrainingForRoutine
    private List<ResponseTrainingForRoutineDTO> trainingsForRoutine;
}