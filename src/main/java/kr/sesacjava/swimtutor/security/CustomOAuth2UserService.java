package kr.sesacjava.swimtutor.security;

import kr.sesacjava.swimtutor.oauth.domain.OAuthLogin;
import kr.sesacjava.swimtutor.oauth.domain.OAuthLoginId;
import kr.sesacjava.swimtutor.oauth.repository.OAuthLoginRepository;
import kr.sesacjava.swimtutor.security.dto.OAuthSecurityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final OAuthLoginRepository oAuthLoginRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("userReuqest");
        log.info(userRequest);
        log.info("oauth2 user....................................");

        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        String clientName = clientRegistration.getClientName();

        log.info("name: " + clientName);
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> paramMap = oAuth2User.getAttributes();

        String email = null;

        switch (clientName) {
            case "google":
                email = getGoogleEmail(paramMap);
                break;
        }

        log.info("================================");
        log.info(email);
        log.info("================================");

        /*paramMap.forEach((k,v) -> {
            log.info("--------------------------------");
            log.info(k + ":" + v);
        });*/
        return generateDTO(email, paramMap);
    }

    private OAuthSecurityDTO generateDTO(String email, Map<String, Object> params) {
        Optional<OAuthLogin> result = oAuthLoginRepository.findById(new OAuthLoginId(email, "google"));
        log.info(params.get("sub"));
        if (result.isEmpty()) {
            OAuthLogin oAuthLogin = OAuthLogin.builder()
                    .oauthLoginId(email)
                    .oauthLoginPlatform("google")
                    .build();

            oAuthLoginRepository.save(oAuthLogin);

            OAuthSecurityDTO memberSecurityDTO =
                    new OAuthSecurityDTO(email, "1111", "google", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

            memberSecurityDTO.setProps(params);

            return memberSecurityDTO;
        } else {
            OAuthLogin oAuthLogin = result.get();
            OAuthSecurityDTO memberSecurityDTO
                    = new OAuthSecurityDTO(
                    oAuthLogin.getOauthLoginId(),
                    "1111",
                    oAuthLogin.getOauthLoginPlatform(),
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
//                    oAuthLogin.getRoleSet()
//                            .stream().map(memberRole -> new SimpleGrantedAuthority("ROLE_" + memberRole.name()))
//                            .toList()

            );

            return memberSecurityDTO;
        }
    }

    private String getGoogleEmail(Map<String, Object> paramMap) {
        Object value = paramMap.get("email");

        return (String) value;
    }


   /* @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;

        if (registrationId.equals("google")) {
            // 구글 로그인일 경우
            System.out.println("구글 로그인");
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }

        // 리소스 서버에서 받은 정보로 사용자를 특정할 아이디값을 만듦
        String username = oAuth2Response.getProvider() + "_" + oAuth2Response.getProviderId();

        // 이미 가입한 사용자인지 확인
        OauthEntity existData = oauthRepository.findByUsername(username);

        if (existData == null) {
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
    }*/

}
