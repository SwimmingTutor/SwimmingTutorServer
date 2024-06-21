package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTrainingForRoutineDTO {
    // TrainingForRoutine
    private String session;

    // Training
    private String strokeName;
    private int distance;
    private int sets;
}