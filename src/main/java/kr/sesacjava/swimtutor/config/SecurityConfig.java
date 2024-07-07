package kr.sesacjava.swimtutor.config;

import kr.sesacjava.swimtutor.jwt.JWTFilter;
import kr.sesacjava.swimtutor.jwt.JWTUtil;
import kr.sesacjava.swimtutor.oauth2.CustomSuccessHandler;
import kr.sesacjava.swimtutor.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final CustomOAuth2UserService customOAuth2UserService;
  private final CustomSuccessHandler customSuccessHandler;
  private final JWTUtil jwtUtil;

  public SecurityConfig(CustomOAuth2UserService customOAuth2UserService, CustomSuccessHandler customSuccessHandler, JWTUtil jwtUtil) {
    this.customOAuth2UserService = customOAuth2UserService;
    this.customSuccessHandler = customSuccessHandler;
    this.jwtUtil = jwtUtil;
  }

  @Bean
  public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
    // JWT를 통한 인증/인가 작업하기 때문에 설정하는 것들 -

    //csrf disable
    http
        .csrf((auth) -> auth.disable());

    //From 로그인 방식 disable
    http
        .formLogin((auth) -> auth.disable());

    //HTTP Basic 인증 방식 disable
    http
        .httpBasic((auth) -> auth.disable());

    // JWTFilter 추가
    http
        .addFilterBefore(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

    //oauth2 - 로그인 설정
    http
        .oauth2Login((oauth2) -> oauth2
            .userInfoEndpoint((userInfoEndpointConfig) -> userInfoEndpointConfig
                .userService(customOAuth2UserService))
            .successHandler(customSuccessHandler)
        );

    //경로별 인가 작업
    http
        .authorizeHttpRequests((auth) -> auth
            .requestMatchers("/").permitAll()
            .anyRequest().authenticated());

    //세션 설정 : STATELESS
    http
        .sessionManagement((session) -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    return http.build();
  }
}
