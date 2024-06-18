package kr.sesacjava.swimtutor.oauthLogin.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OauthLoginDTO {

    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String idToken;
    private String accessToken;
    private String refreshToken;
    private Date tokenExpiry;
    private LocalDateTime created;
    private LocalDateTime updated;
}
