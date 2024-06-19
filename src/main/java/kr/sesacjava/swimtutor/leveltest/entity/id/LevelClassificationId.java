package kr.sesacjava.swimtutor.leveltest.entity.id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class LevelClassificationId implements Serializable {
    private String lcTrainingName;
    private String userLevel;
    private String standardName;
}
