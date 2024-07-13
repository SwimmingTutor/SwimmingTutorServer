package kr.sesacjava.swimtutor.leveltest.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class ChatGPTService {

    private final RestTemplate restTemplate;

    public ChatGPTService() {
        this.restTemplate = new RestTemplate();
    }

    // OpenAI API에 보낼 요청 본문을 구성하는 메소드
    private String buildRequestBody(String prompt) {
        return String.format("{\"prompt\": \"%s\", \"max_tokens\": 150}", prompt);
    }

    public String getChatGPTResponse(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(System.getenv("OPEN_AI_API_KEY")); // OpenAI API 키

        // 요청 본문 구성
        String requestBody = buildRequestBody(prompt);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // OpenAI API 엔드포인트
        String url = "https://chatgpt.com/g/g-u9OS67xTI-swimming-level-test-for-korean";

        // POST 요청 보내고 응답 받기
        String response = restTemplate.postForObject(url, request, String.class);
        return response;
    }
}
