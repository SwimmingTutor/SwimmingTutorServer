package kr.sesacjava.swimtutor.routine.entity.id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
public class TrainingForRoutineId implements Serializable {
    private Integer routineId;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String trainingId;
}