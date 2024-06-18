package kr.sesacjava.swimtutor.oauthData.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "oauth_data")
@IdClass(OauthDataId.class)
@Getter
@ToString
public class OauthData {
    @Id
    @Column(name = "data_type")
    private String dataType;

    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform")
    private String oauthLoginPlatform;

    @Column(name = "oauth_app_id")
    private String oauthAppId;

    @Column(name = "changes_token")
    private String changesToken;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}
