package kr.sesacjava.swimtutor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "oauth_login")
@IdClass(OauthLoginId.class)
@Getter
@ToString
public class OauthLogin {
    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform")
    private String oauthLoginPlatform;

    @Column(name = "id_token")
    private String idToken;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "token_expiry")
    private LocalDate tokenExpiry;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}