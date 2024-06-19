package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.routine.entity.id.TrainingForRoutineId;
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

    public TrainingForRoutine() {
    }

    public TrainingForRoutine(Integer routineId, String oauthLoginId, String oauthLoginPlatform, String session, String trainingId, LocalDateTime created, LocalDateTime updated) {
        this.routineId = routineId;
        this.oauthLoginId = oauthLoginId;
        this.oauthLoginPlatform = oauthLoginPlatform;
        this.session = session;
        this.trainingId = trainingId;
        this.created = created;
        this.updated = updated;
    }

    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    public String getOauthLoginId() {
        return oauthLoginId;
    }

    public void setOauthLoginId(String oauthLoginId) {
        this.oauthLoginId = oauthLoginId;
    }

    public String getOauthLoginPlatform() {
        return oauthLoginPlatform;
    }

    public void setOauthLoginPlatform(String oauthLoginPlatform) {
        this.oauthLoginPlatform = oauthLoginPlatform;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}