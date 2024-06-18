package kr.sesacjava.swimtutor.entity;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class OauthDataId implements Serializable {
    private String dataType;
    private String oauthLoginId;
    private String oauthLoginPlatform;
}
