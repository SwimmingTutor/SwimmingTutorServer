package kr.sesacjava.swimtutor.routine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class ResponseRoutineDTO {
    // Routine
    private String routineName;
    private int unitLength;
    private int targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;

    public ResponseRoutineDTO() {
    }

    public ResponseRoutineDTO(String routineName, int unitLength, int targetDistance, String selStrokes, LocalDateTime created, LocalDateTime updated) {
        this.routineName = routineName;
        this.unitLength = unitLength;
        this.targetDistance = targetDistance;
        this.selStrokes = selStrokes;
        this.created = created;
        this.updated = updated;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public int getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(int unitLength) {
        this.unitLength = unitLength;
    }

    public int getTargetDistance() {
        return targetDistance;
    }

    public void setTargetDistance(int targetDistance) {
        this.targetDistance = targetDistance;
    }

    public String getSelStrokes() {
        return selStrokes;
    }

    public void setSelStrokes(String selStrokes) {
        this.selStrokes = selStrokes;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}