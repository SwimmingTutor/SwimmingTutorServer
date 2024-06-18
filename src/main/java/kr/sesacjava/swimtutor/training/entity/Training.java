package kr.sesacjava.swimtutor.training.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "training")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @Column(name = "training_id")
    private String trainingId;

    @Column(name = "training_name")
    private String trainingName;

    @Column(name = "user_level")
    private String userLevel;

    @Column(name = "training_level")
    private String trainingLevel;

    @Column(name = "distance")
    private int distance;

    @Column(name = "sets")
    private int sets;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}