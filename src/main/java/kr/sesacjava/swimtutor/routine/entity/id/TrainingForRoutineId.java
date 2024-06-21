package kr.sesacjava.swimtutor.routine.entity.id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
public class TrainingForRoutineId implements Serializable {
    private Integer routineNo;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String trainingId;
}