package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRoutineDTO {
    // Routine
    private String routineName;
    private int poolLength;
    private int targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;
}