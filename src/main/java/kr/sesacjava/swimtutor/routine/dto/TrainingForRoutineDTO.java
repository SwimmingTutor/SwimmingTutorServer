package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingForRoutineDTO {
    // TrainingForRoutine
    private String session;

    // Training
    private String trainingId;
    private String strokeName;
    private Integer distance;
    private Integer sets;
}