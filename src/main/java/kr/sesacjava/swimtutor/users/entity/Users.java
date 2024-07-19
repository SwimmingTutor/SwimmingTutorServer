package kr.sesacjava.swimtutor.users.entity;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.common.entity.BaseEntity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user",
        uniqueConstraints = {@UniqueConstraint(
                name = "UniqueName",
                columnNames = {"name"}
        )}
)
@IdClass(UsersId.class)
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users extends BaseEntity {
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
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "preference")
    private String preference;

    @Column(name = "goal")
    private String goal;

}
