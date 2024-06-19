package kr.sesacjava.swimtutor.routine.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestRoutineDTO {
    // RoutineId
    private int routineId;
    private String oauthLoginId;
    private String oauthLoginPlatform;

    // Routine
    private String routineName;
    private int unitLength;
    private int targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getSelStrokes() {
        return selStrokes;
    }

    public void setSelStrokes(String selStrokes) {
        this.selStrokes = selStrokes;
    }

    public int getTargetDistance() {
        return targetDistance;
    }

    public void setTargetDistance(int targetDistance) {
        this.targetDistance = targetDistance;
    }

    public int getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(int unitLength) {
        this.unitLength = unitLength;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public String getOauthLoginPlatform() {
        return oauthLoginPlatform;
    }

    public void setOauthLoginPlatform(String oauthLoginPlatform) {
        this.oauthLoginPlatform = oauthLoginPlatform;
    }

    public String getOauthLoginId() {
        return oauthLoginId;
    }

    public void setOauthLoginId(String oauthLoginId) {
        this.oauthLoginId = oauthLoginId;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }
}