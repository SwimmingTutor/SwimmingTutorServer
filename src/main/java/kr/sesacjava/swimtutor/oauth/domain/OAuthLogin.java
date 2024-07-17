package kr.sesacjava.swimtutor.oauth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import kr.sesacjava.swimtutor.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(OAuthLoginId.class)
public class OAuthLogin extends BaseEntity {
    @Id
    private String oauthLoginId;

    @Id
    private String oauthLoginPlatform;

}
