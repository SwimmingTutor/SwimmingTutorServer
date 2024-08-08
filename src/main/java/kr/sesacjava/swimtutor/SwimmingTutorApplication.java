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

    @PostConstruct
    private static void startPythonServer() {
        new Thread(() -> {
            try {
                // 현재 작업 디렉토리 설정 및 Python 스크립트 경로 설정
                String currentDir = new File(".").getCanonicalPath();
                String pythonPath = currentDir + File.separator + ".pyenv" + File.separator + "Scripts" + File.separator + "python.exe";
                String pythonScriptPath = currentDir + File.separator + "ai" + File.separator + "__main__.py";

                // ProcessBuilder 정의 및 설정
                ProcessBuilder pb = new ProcessBuilder(pythonPath, pythonScriptPath);
                pb.redirectErrorStream(true);
                Process p = pb.start();

                // Python 서버 출력 읽기
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    if (line.contains("Application startup complete.")) { // 서버 시작 확인 메시지
                        break;
                    }
                }

                // 추가 대기 시간 (옵션)
                Thread.sleep(5000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
