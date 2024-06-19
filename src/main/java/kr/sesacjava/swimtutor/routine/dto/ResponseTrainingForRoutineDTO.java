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
    private String TrainingId;
    private String strokeName;
    private int distance;
    private int sets;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(String trainingId) {
        TrainingId = trainingId;
    }

    public String getStrokeName() {
        return strokeName;
    }

    public void setStrokeName(String strokeName) {
        this.strokeName = strokeName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
}