package kr.sesacjava.swimtutor.record.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExerciseRecordId implements Serializable {
    private LocalDateTime startTime;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String category;
}
