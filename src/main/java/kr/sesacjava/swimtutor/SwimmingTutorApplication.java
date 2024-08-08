package kr.sesacjava.swimtutor;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableJpaAuditing
public class SwimmingTutorApplication {
    public static void main(String[] args) {
        // Spring Boot application 실행 (예제에서는 간단히 출력으로 대체)
        SpringApplication.run(SwimmingTutorApplication.class, args);
    }
}
