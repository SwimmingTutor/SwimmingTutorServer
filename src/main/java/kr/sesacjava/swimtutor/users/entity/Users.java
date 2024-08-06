package kr.sesacjava.swimtutor.users.entity;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.common.entity.BaseEntity;
import kr.sesacjava.swimtutor.users.dto.UsersExperienceDTO;
import kr.sesacjava.swimtutor.users.dto.UsersProfileDTO;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "users",
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


    public void changeExperience(UsersExperienceDTO dto) {
        this.preference = dto.getPreference();
        this.goal = dto.getGoal();
    }

    public void changeProfile(UsersProfileDTO dto) {
        this.name = dto.getName();
        this.gender = dto.getGender();
        this.birth = dto.getBirth();
        this.weight = dto.getWeight();
        this.height = dto.getHeight();
    }
}
