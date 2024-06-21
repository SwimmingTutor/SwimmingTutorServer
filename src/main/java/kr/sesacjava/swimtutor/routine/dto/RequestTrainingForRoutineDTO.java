package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestTrainingForRoutineDTO {
    // TrainingForRoutine
    private String session;

    // Training
    private String trainingId;
    private String strokeName;
    private int distance;
    private int sets;
}