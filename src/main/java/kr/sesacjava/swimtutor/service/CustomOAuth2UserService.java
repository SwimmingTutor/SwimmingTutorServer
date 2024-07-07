package kr.sesacjava.swimtutor.service;

import kr.sesacjava.swimtutor.dto.CustomOAuth2User;
import kr.sesacjava.swimtutor.dto.GoogleResponse;
import kr.sesacjava.swimtutor.dto.OAuth2Response;
import kr.sesacjava.swimtutor.dto.UserDTO;
import kr.sesacjava.swimtutor.entity.UserEntity;
import kr.sesacjava.swimtutor.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

  private final UserRepository userRepository;

  public CustomOAuth2UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
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
    UserEntity existData = userRepository.findByUsername(username);

    if(existData==null) {
      UserEntity userEntity = new UserEntity();
      userEntity.setUsername(username);
      userEntity.setEmail(oAuth2Response.getEmail());
      userEntity.setName(oAuth2Response.getName());
      userEntity.setRole("ROLE_USER");

      userRepository.save(userEntity);

      UserDTO userDTO = new UserDTO();
      userDTO.setUsername(username);
      userDTO.setName(oAuth2Response.getName());
      userDTO.setRole("ROLE_USER");

      return new CustomOAuth2User(userDTO);

    } else {

      existData.setEmail(oAuth2Response.getEmail());
      existData.setName(oAuth2Response.getName());
      userRepository.save(existData);

      UserDTO userDTO = new UserDTO();
      userDTO.setUsername(existData.getUsername());
      userDTO.setName(oAuth2Response.getName());
      userDTO.setRole(existData.getRole());

      return new CustomOAuth2User(userDTO);
    }
  }
}
