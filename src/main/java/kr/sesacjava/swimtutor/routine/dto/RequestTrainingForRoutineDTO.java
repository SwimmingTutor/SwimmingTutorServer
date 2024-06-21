package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestTrainingForRoutineDTO {
    // ResponseTrainingForRoutine
    private String session;

    // Training
    private String trainingId;
    private String strokeName;
    private int distance;
    private int sets;

    @Builder
    public RequestTrainingForRoutineDTO(String session, String trainingId, String strokeName, int distance, int sets) {
        this.session = session;
        this.trainingId = trainingId;
        this.strokeName = strokeName;
        this.distance = distance;
        this.sets = sets;
    }
}