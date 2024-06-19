package kr.sesacjava.swimtutor.routine.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoutineDTO {

    //    private int routineId;
//    private String oauthLoginId;
//    private String oauthLoginPlatform;
    private String routineName;
    private int unitLength;
    private int targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;
}