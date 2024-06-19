package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "routine")
@IdClass(RoutineId.class)
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id")
    private Integer routineId;

    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform")
    private String oauthLoginPlatform;

    @Column(name = "routine_name")
    private String routineName;

    @Column(name = "unit_length")
    private int unitLength;

    @Column(name = "target_distance")
    private int targetDistance;

    @Column(name = "sel_strokes")
    private String selStrokes;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    public Integer getRoutineId() {
        return routineId;
    }

    public String getOauthLoginId() {
        return oauthLoginId;
    }

    public String getOauthLoginPlatform() {
        return oauthLoginPlatform;
    }

    public String getRoutineName() {
        return routineName;
    }

    public int getUnitLength() {
        return unitLength;
    }

    public int getTargetDistance() {
        return targetDistance;
    }

    public String getSelStrokes() {
        return selStrokes;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}