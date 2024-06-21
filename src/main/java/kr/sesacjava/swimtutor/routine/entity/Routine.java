package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "routine")
@IdClass(RoutineId.class)
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id")
    private int routineNo;

    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform", length = 32)
    private String oauthLoginPlatform;

    @Column(name = "routine_name", length = 20)
    private String routineName;

    @Column(name = "pool_length")
    private int poolLength;

    @Column(name = "target_distance")
    private int targetDistance;

    @Column(name = "sel_strokes")
    private String selStrokes;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Builder
    public Routine(String oauthLoginId, String oauthLoginPlatform, String routineName, int poolLength, int targetDistance, String selStrokes, LocalDateTime created, LocalDateTime updated) {
        this.oauthLoginId = oauthLoginId;
        this.oauthLoginPlatform = oauthLoginPlatform;
        this.routineName = routineName;
        this.poolLength = poolLength;
        this.targetDistance = targetDistance;
        this.selStrokes = selStrokes;
        this.created = created;
        this.updated = updated;
    }
}