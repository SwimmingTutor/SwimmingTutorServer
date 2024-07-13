package kr.sesacjava.swimtutor.records.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class RecordId implements Serializable {
    @Column(name = "starttime", nullable = false)
    private LocalDateTime starttime;

    @Column(name = "oauth_login_id", nullable = false)
    private String oauthLoginId;

    @Column(name = "oauth_login_platform", nullable = false)
    private String oauthLoginPlatform;

    @Column(name = "category", nullable = false)
    private String category;
}