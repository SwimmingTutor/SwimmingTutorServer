package kr.sesacjava.swimtutor.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@ToString
public class OAuthSecurityDTO extends User implements OAuth2User {
    private String email;
    private String platform;
    private String getProviderId;

    private Map<String, Object> props;

    public OAuthSecurityDTO(String username, String password, String platform, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.getProviderId = password;
        this.platform = platform;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.getProps();
    }

    @Override
    public String getName() {
        return this.email;
    }
}
