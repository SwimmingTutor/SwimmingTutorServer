package kr.sesacjava.swimtutor.oauth.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OAuthLoginId implements Serializable {
    private String oauthLoginId;
    private String oauthLoginPlatform;
}
