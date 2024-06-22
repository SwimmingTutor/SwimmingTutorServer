package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseTrainingForRoutineDTO {
    // ResponseTrainingForRoutine
    private String session;

    // Training
    private String strokeName;
    private int distance;
    private int sets;

    @Builder
    public ResponseTrainingForRoutineDTO(String session, String strokeName, int distance, int sets) {
        this.session = session;
        this.strokeName = strokeName;
        this.distance = distance;
        this.sets = sets;
    }
}