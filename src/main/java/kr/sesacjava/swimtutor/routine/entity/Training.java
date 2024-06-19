package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String strokeName;

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

    public String getTrainingId() {
        return trainingId;
    }

    public String getStrokeName() {
        return strokeName;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public int getDistance() {
        return distance;
    }

    public int getSets() {
        return sets;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}