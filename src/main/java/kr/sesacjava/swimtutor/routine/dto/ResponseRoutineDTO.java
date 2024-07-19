package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseRoutineDTO {
    // Routine
    private String routineName;
    private int poolLength;
    private int targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Builder
    public ResponseRoutineDTO(String routineName, int poolLength, int targetDistance, String selStrokes, LocalDateTime created, LocalDateTime updated) {
        this.routineName = routineName;
        this.poolLength = poolLength;
        this.targetDistance = targetDistance;
        this.selStrokes = selStrokes;
        this.created = created;
        this.updated = updated;
    }
}