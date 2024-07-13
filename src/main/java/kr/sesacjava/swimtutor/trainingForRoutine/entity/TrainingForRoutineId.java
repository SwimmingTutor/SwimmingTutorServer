package kr.sesacjava.swimtutor.trainingForRoutine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrainingForRoutineId implements Serializable {
    private Integer routineId;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String trainingId;
}