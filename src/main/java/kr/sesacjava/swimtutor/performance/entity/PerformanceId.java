package kr.sesacjava.swimtutor.performance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceId implements Serializable {
    private String performanceName;
    private String oauthLoginId;
    private String oauthLoginPlatform;
}
