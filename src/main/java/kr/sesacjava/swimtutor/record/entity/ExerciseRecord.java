package kr.sesacjava.swimtutor.record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import kr.sesacjava.swimtutor.common.entity.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "exercise_record")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(ExerciseRecordId.class)
public class ExerciseRecord extends BaseEntity {
    @Id
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;
    @Id
    @Column(name = "oauth_login_platform")
    private String oauthLoginPlatform;
    @Id
    private String category;

    @Column(name = "stop_time")
    private LocalDateTime stopTime;

    private Double value;
}
