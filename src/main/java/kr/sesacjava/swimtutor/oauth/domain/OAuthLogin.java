package kr.sesacjava.swimtutor.oauth.domain;

import jakarta.persistence.*;
import kr.sesacjava.swimtutor.common.entity.BaseEntity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "oauth_login")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(OAuthLoginId.class)
@ToString(exclude = "roleSet")
public class OAuthLogin extends BaseEntity {
    @Id
    @Column(name = "oauth_login_id")
    private String oauthLoginId;

    @Id
    @Column(name = "oauth_login_platform")
    private String oauthLoginPlatform;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addRole(MemberRole memberRole) {
        this.roleSet.add(memberRole);
    }

}
