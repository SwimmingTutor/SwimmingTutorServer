package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseRoutineDTO {
    // Routine
    private Integer routineNo;
    private String routineName;
    private Integer poolLength;
    private Integer targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;
}