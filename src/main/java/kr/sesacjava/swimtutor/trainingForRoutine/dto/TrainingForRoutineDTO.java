package kr.sesacjava.swimtutor.trainingForRoutine.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrainingForRoutineDTO {

    private int routineId;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String session;
    private String trainingId;
    private LocalDateTime created;
    private LocalDateTime updated;
}
