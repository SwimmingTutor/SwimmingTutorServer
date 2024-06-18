package kr.sesacjava.swimtutor.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class LevelDTO {

    private int levellogId;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private LocalDateTime created;
    private LocalDateTime updated;
}
