package kr.sesacjava.swimtutor.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserExerciseRecordId implements Serializable {
    private LocalDateTime startTime;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String category;
}
