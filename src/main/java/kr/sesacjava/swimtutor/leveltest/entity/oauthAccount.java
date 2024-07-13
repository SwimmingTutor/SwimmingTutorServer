package kr.sesacjava.swimtutor.leveltest.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class oauthAccount {

    private String oauthLoginId;
    private String oauthLoginPlatform;

    public oauthAccount() {
    }

    public oauthAccount(String oauthLoginId, String oauthLoginPlatform) {
        this.oauthLoginId = oauthLoginId;
        this.oauthLoginPlatform = oauthLoginPlatform;
    }

    // getters & setters
    public String getOauthLoginId() {
        return oauthLoginId;
    }

    public void setOauthLoginId(String oauthLoginId) {
        this.oauthLoginId = oauthLoginId;
    }

    public String getOauthLoginPlatform() {
        return oauthLoginPlatform;
    }

    public void setOauthLoginPlatform(String oauthLoginPlatform) {
        this.oauthLoginPlatform = oauthLoginPlatform;
    }

    // equals & hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        oauthAccount that = (oauthAccount) o;
        return Objects.equals(oauthLoginId, that.oauthLoginId) && Objects.equals(oauthLoginPlatform, that.oauthLoginPlatform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oauthLoginId, oauthLoginPlatform);
    }
}
