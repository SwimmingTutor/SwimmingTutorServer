package kr.sesacjava.swimtutor.performance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "performance")
@IdClass(PerformanceId.class)
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Performance {
    @Id
    @Column(name = "performance_name")
    private String performanceName;

    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform")
    private String oauthLoginPlatform;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}
