package kr.sesacjava.swimtutor.leveltest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "level_log")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_log_id", nullable = false)
    private Integer levelLogId;

    @Column(name = "oauth_login_id", nullable = false)
    private String oauthLoginId;

    @Column(name = "oauth_login_platform", nullable = false)
    private String oauthLoginPlatform;

    @Column(name = "lc_training_name", nullable = false)
    private String lcTrainingName;

    @Column(name = "user_level", nullable = false)
    private String userLevel;

    @CreatedDate
    @Column(name = "created", nullable = false, updatable = false, insertable = false, columnDefinition = "datetime default current_timestamp")
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated", nullable = false, insertable = false, columnDefinition = "datetime default current_timestamp on update current_timestamp")
    private LocalDateTime updated;

    public void change(String lcTrainingName, String userLevel) {
        this.lcTrainingName = lcTrainingName;
        this.userLevel = userLevel;
    }
}
