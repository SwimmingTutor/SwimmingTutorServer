package kr.sesacjava.swimtutor.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomOAuth2User implements OAuth2User {

  private final OauthDTO oauthDTO;

  public CustomOAuth2User(OauthDTO oauthDTO) {
    this.oauthDTO = oauthDTO;
  }

  @Override
  public Map<String, Object> getAttributes() {
    // 사용 X
    return null;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collection = new ArrayList<>();
    collection.add(new GrantedAuthority() {
      @Override
      public String getAuthority() {
        return oauthDTO.getRole();
      }
    });
    return collection;
  }

  @Override
  public String getName() {
    return oauthDTO.getName();
  }

  public String getUsername() {
    return oauthDTO.getUsername();
  }
}
