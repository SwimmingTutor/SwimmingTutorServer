package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.*;
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
}
