package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.routine.entity.id.TrainingForRoutineId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "training_for_routine")
@IdClass(TrainingForRoutineId.class)
@Getter
@ToString
@NoArgsConstructor
public class TrainingForRoutine {

    @Id
    @Column(name = "routine_no", nullable = false)
    private Integer routineNo;

    @Id
    @Column(name = "oauth_login_id", nullable = false)
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform", nullable = false)
    private String oauthLoginPlatform;

    @Column(name = "session", nullable = false, length = 10)
    private String session;

    @Id
    @Column(name = "training_id", nullable = false, length = 8)
    private String trainingId;

    @Column(name = "created", nullable = false, updatable = false, insertable = false, columnDefinition = "datetime default current_timestamp")
    private LocalDateTime created;

    @Column(name = "updated", nullable = false, insertable = false, columnDefinition = "datetime default current_timestamp on update current_timestamp")
    private LocalDateTime updated;

    @Builder
    public TrainingForRoutine(Integer routineNo, String oauthLoginId, String oauthLoginPlatform, String session, String trainingId) {
        this.routineNo = routineNo;
        this.oauthLoginId = oauthLoginId;
        this.oauthLoginPlatform = oauthLoginPlatform;
        this.session = session;
        this.trainingId = trainingId;
    }
}