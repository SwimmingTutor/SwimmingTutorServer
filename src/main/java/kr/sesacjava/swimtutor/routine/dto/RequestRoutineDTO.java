package kr.sesacjava.swimtutor.routine.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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