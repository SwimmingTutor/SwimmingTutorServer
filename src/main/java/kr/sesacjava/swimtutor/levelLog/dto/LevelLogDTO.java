package kr.sesacjava.swimtutor.levelLog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LevelLogDTO {

    private int levellogId;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String lcTrainingName;
    private String userLevel;
    private String standardName;
    private LocalDateTime created;
    private LocalDateTime updated;
}
