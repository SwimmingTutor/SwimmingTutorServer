package kr.sesacjava.swimtutor.entity;

import lombok.Getter;
import lombok.ToString;
import java.io.Serializable;

@Getter
@ToString
public class LevelClassificationId implements Serializable {
    private String lcTrainingName;
    private String userLevel;
    private String standardName;
}
