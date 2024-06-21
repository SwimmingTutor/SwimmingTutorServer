package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "training")
@Getter
@ToString
@NoArgsConstructor
public class Training {
    @Id
    @Column(name = "training_id", length = 8)
    private String trainingId;

    @Column(name = "training_name", length = 10)
    private String strokeName;

    @Column(name = "user_level", length = 3)
    private String userLevel;

    @Column(name = "training_level", length = 3)
    private String strokeLevel;

    @Column(name = "distance")
    private int distance;

    @Column(name = "sets")
    private int sets;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}