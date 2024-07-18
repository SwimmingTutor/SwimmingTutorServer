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
}