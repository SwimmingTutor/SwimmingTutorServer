package kr.sesacjava.swimtutor.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*
        * TODO: 삭제 필요!:
        *  api요청 테스트 때문에 설정해둠.
        * */

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((registry) ->
                        registry.requestMatchers("/")
                                .permitAll()
                                .anyRequest().authenticated())
                .build();
    }
}