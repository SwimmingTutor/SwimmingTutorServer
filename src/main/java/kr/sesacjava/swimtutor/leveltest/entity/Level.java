package kr.sesacjava.swimtutor.leveltest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "level")
@Getter
@ToString
public class Level {

    @Id
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
}
