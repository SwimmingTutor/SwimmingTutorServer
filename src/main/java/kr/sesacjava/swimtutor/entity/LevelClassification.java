package kr.sesacjava.swimtutor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "level_classification")
@IdClass(LevelClassificationId.class)
@Getter
@ToString
public class LevelClassification {
    @Id
    @Column(name = "lc_training_name")
    private String lcTrainingName;

    @Id
    @Column(name = "user_level")
    private String userLevel;

    @Id
    @Column(name = "standard_name")
    private String standardName;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}
