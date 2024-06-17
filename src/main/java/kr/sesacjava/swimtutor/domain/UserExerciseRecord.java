package kr.sesacjava.swimtutor.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(UserExerciseRecordId.class)
public class UserExerciseRecord extends BaseEntity {
    @Id
    private LocalDateTime startTime;
    @Id
    private String oauthLoginId;
    @Id
    private String oauthLoginPlatform;
    @Id
    private String category;

    private Double record;
}
