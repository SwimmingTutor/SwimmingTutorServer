package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestRoutineDTO {
    // RoutineId
    private String oauthLoginId;
    private String oauthLoginPlatform;

    // Routine
    private String routineName;
    private int poolLength;
    private int targetDistance;
    private String selStrokes;
}