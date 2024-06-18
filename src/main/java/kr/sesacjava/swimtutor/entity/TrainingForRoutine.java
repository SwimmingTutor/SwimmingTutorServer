package kr.sesacjava.swimtutor.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "training_for_routine")
@IdClass(TrainingForRoutineId.class)
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrainingForRoutine {

    @Id
    @Column(name = "routine_id", nullable = false)
    private Integer routineId;

    @Id
    @Column(name = "oauth_login_id", nullable = false)
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform", nullable = false)
    private String oauthLoginPlatform;

    @Column(name = "session", nullable = false)
    private String session;

    @Id
    @Column(name = "training_id", nullable = false)
    private String trainingId;

    @Column(name = "created", nullable = false, updatable = false, insertable = false, columnDefinition = "datetime default current_timestamp")
    private LocalDateTime created;

    @Column(name = "updated", nullable = false, insertable = false, columnDefinition = "datetime default current_timestamp on update current_timestamp")
    private LocalDateTime updated;
}
