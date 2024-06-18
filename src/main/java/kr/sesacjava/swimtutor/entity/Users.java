package kr.sesacjava.swimtutor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@IdClass(UsersId.class)
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform", length = 32)
    private String oauthLoginPlatform;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "height")
    private Float height;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "preference")
    private String preference;

    @Column(name = "goal")
    private String goal;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}
