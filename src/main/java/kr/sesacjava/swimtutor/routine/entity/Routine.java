package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "routine")
@IdClass(RoutineId.class)
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Routine {
    @Id
    @Column(name = "routine_no")
    private Integer routineNo;

    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform")
    private String oauthLoginPlatform;

    @Column(name = "routine_name")
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

    public void change(String routineName, int poolLength, int targetDistance, String selStrokes) {
        this.routineName = routineName;
        this.poolLength = poolLength;
        this.targetDistance = targetDistance;
        this.selStrokes = selStrokes;
    }
}