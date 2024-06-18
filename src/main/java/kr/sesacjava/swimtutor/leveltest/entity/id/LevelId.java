package kr.sesacjava.swimtutor.leveltest.entity.id;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class LevelId implements Serializable {
    private Integer levelLogId;
    private String oauthLoginId;
    private String oauthLoginPlatform;
}