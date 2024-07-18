package kr.sesacjava.swimtutor.performance.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDTO {

    private String performanceName;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private LocalDateTime created;
    private LocalDateTime updated;
}
