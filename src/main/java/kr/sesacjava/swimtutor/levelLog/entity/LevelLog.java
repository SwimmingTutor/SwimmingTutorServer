package kr.sesacjava.swimtutor.levelLog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "level_log")
@Getter
@ToString
public class LevelLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "levelLog_id", nullable = false)
    private Integer levelLogId;

    @Column(name = "oauth_login_id", nullable = false)
    private String oauthLoginId;

    @Column(name = "oauth_login_platform", nullable = false)
    private String oauthLoginPlatform;

    @Column(name = "lc_training_name", nullable = false)
    private String lcTrainingName;

    @Column(name = "user_level", nullable = false)
    private String userLevel;

    @Column(name = "standard_name", nullable = false)
    private String standardName;

    @Column(name = "created", nullable = false, updatable = false, insertable = false, columnDefinition = "datetime default current_timestamp")
    private LocalDateTime created;

    @Column(name = "updated", nullable = false, insertable = false, columnDefinition = "datetime default current_timestamp on update current_timestamp")
    private LocalDateTime updated;
}