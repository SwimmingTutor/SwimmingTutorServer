package kr.sesacjava.swimtutor.jwt;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import kr.sesacjava.swimtutor.dto.CustomOAuth2User;
import kr.sesacjava.swimtutor.dto.UserDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTFilter extends OncePerRequestFilter {

  private final JWTUtil jwtUtil;

  public JWTFilter(JWTUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    // cookies에서 Authorization 키를 가진 쿠키를 찾아서 토큰을 가져온다.
    String authorization = null;
    Cookie[] cookies = request.getCookies();
    for(Cookie cookie : cookies) {
      System.out.println(cookie.getName());
      if(cookie.getName().equals("Authorization")) {
        authorization = cookie.getValue();
      }
    }

    // Authorization 헤더 검증
    if(authorization==null) {
      System.out.println("토큰이 없습니다.");
      filterChain.doFilter(request, response);

      return;
    }

    String token = authorization;

    // 토큰 소멸시간 검증
    if(jwtUtil.isExpired(token)) {
      System.out.println("token expired");
      filterChain.doFilter(request, response);

      return;
    }

    // 토큰에서 username, role을 가져온다.
    String username = jwtUtil.getUsername(token);
    String role = jwtUtil.getRole(token);

    UserDTO userDTO = new UserDTO();
    userDTO.setUsername(username);
    userDTO.setRole(role);

    CustomOAuth2User customOAuth2Uer = new CustomOAuth2User(userDTO);

    Authentication authToken = new UsernamePasswordAuthenticationToken(customOAuth2Uer, null, customOAuth2Uer.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authToken);

    filterChain.doFilter(request, response);
  }
}
