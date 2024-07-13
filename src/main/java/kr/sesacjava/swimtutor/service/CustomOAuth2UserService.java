package kr.sesacjava.swimtutor.service;

import kr.sesacjava.swimtutor.dto.CustomOAuth2User;
import kr.sesacjava.swimtutor.dto.GoogleResponse;
import kr.sesacjava.swimtutor.dto.OAuth2Response;
import kr.sesacjava.swimtutor.dto.OauthDTO;
import kr.sesacjava.swimtutor.entity.OauthEntity;
import kr.sesacjava.swimtutor.repository.OauthRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

  private final OauthRepository oauthRepository;

  public CustomOAuth2UserService(OauthRepository oauthRepository) {
    this.oauthRepository = oauthRepository;
  }

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

    OAuth2User oAuth2User = super.loadUser(userRequest);
    System.out.println(oAuth2User);

    String registrationId = userRequest.getClientRegistration().getRegistrationId();
    OAuth2Response oAuth2Response = null;

    if(registrationId.equals("google")) {
      // 구글 로그인일 경우
      System.out.println("구글 로그인");
      oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
    }

    // 리소스 서버에서 받은 정보로 사용자를 특정할 아이디값을 만듦
    String username = oAuth2Response.getProvider() + "_" + oAuth2Response.getProviderId();

    // 이미 가입한 사용자인지 확인
    OauthEntity existData = oauthRepository.findByUsername(username);

    if(existData==null) {
      OauthEntity userEntity = new OauthEntity();
      userEntity.setUsername(username);
      userEntity.setEmail(oAuth2Response.getEmail());
      userEntity.setName(oAuth2Response.getName());
      userEntity.setRole("ROLE_USER");

      oauthRepository.save(userEntity);

      OauthDTO oauthDTO = new OauthDTO();
      oauthDTO.setUsername(username);
      oauthDTO.setName(oAuth2Response.getName());
      oauthDTO.setRole("ROLE_USER");

      return new CustomOAuth2User(oauthDTO);

    } else {

      existData.setEmail(oAuth2Response.getEmail());
      existData.setName(oAuth2Response.getName());
      oauthRepository.save(existData);

      OauthDTO oauthDTO = new OauthDTO();
      oauthDTO.setUsername(existData.getUsername());
      oauthDTO.setName(oAuth2Response.getName());
      oauthDTO.setRole(existData.getRole());

      return new CustomOAuth2User(oauthDTO);
    }
  }
}
