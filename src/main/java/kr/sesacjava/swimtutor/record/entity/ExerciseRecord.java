package kr.sesacjava.swimtutor.record.entity;

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
@IdClass(ExerciseRecordId.class)
public class ExerciseRecord extends BaseEntity {
    @Id
    private LocalDateTime startTime;
    @Id
    private String oauthLoginId;
    @Id
    private String oauthLoginPlatform;
    @Id
    private String category;

    private LocalDateTime stopTime;

    private Double record;
}
