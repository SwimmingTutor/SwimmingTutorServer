package kr.sesacjava.swimtutor.entity;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class OauthLoginId implements Serializable {
    private String oauthLoginId;
    private String oauthLoginPlatform;
}
