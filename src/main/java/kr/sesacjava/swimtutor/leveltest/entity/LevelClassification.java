package kr.sesacjava.swimtutor.leveltest.entity;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.leveltest.entity.id.LevelClassificationId;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "level_classification")
@IdClass(LevelClassificationId.class)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @CreatedDate
    @Column(name = "created")
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated")
    private LocalDateTime updated;
}
