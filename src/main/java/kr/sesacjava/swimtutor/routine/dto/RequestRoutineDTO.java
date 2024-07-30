package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestRoutineDTO {
    // Routine
    private String routineName;
    private Integer poolLength;
    private Integer targetDistance;
    private String selStrokes;
}