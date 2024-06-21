package kr.sesacjava.swimtutor.routine.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestTrainingForRoutineDTO {
    // TrainingForRoutine
    private String session;

    // Training
    private String trainingId;
    private String strokeName;
    private int distance;
    private int sets;
}