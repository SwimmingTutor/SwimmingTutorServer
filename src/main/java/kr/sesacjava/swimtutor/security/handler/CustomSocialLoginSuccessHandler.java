package kr.sesacjava.swimtutor.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.sesacjava.swimtutor.common.util.JWTUtil;
import kr.sesacjava.swimtutor.security.dto.OAuthSecurityDTO;
import kr.sesacjava.swimtutor.users.entity.UsersId;
import kr.sesacjava.swimtutor.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
public class CustomSocialLoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JWTUtil jwtUtil;
    private final UsersRepository usersRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("----------------------------------");
        log.info("CustomLoginSuccessHandler onAuthenticationSuccess");
        log.info(authentication.getPrincipal());

        OAuthSecurityDTO principal = (OAuthSecurityDTO) authentication.getPrincipal();
        String email = authentication.getName();
        String platform = principal.getPlatform();

        Map<String, Object> claim = Map.of("email", email, "platform", platform);
        String accessToken = jwtUtil.generateToken(claim, 1);
        String refreshToken = jwtUtil.generateToken(claim, 10);

        response.addCookie(createCookie("accessToken", accessToken));
        response.addCookie(createCookie("refreshToken", refreshToken));

        boolean exist = usersRepository.existsById(new UsersId(email, platform));
        response.addCookie(createCookie("registered", String.valueOf(exist)));

        response.sendRedirect("http://localhost:3000/accounts/login-redirect");
    }

    private Cookie createCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 60 * 60);
        // cookie.setSecure(true); // https에서만 사용 가능
        cookie.setPath("/");
//        cookie.setHttpOnly(true);

        return cookie;
    }
}
