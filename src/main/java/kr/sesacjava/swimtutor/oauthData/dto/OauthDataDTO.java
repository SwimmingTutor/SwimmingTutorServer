package kr.sesacjava.swimtutor.oauthData.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OauthDataDTO {

    private String dataType;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String oauthAppId;
    private String changesToken;
    private LocalDate expireDate;
    private LocalDateTime created;
    private LocalDateTime updated;
}
