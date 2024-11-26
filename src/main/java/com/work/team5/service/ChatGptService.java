package com.work.team5.service;

import com.work.team5.dto.ChatGptRequest;
import com.work.team5.dto.ChatGptResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ChatGptService 클래스
 * - OpenAI의 ChatGPT API 호출을 처리하는 서비스 클래스
 */
@Service
public class ChatGptService {

    // 로깅을 위한 Logger 인스턴스
    private static final Logger logger = LoggerFactory.getLogger(ChatGptService.class);

    // API URL을 구성 파일에서 주입받음
    @Value("${openai.api.url}")
    private String apiUrl;

    // API 키를 구성 파일에서 주입받음
    @Value("${openai.api.key}")
    private String apiKey;

    // 사용할 모델 이름을 구성 파일에서 주입받음
    @Value("${openai.api.model}")
    private String model;

    // RestTemplate 인스턴스를 주입받음
    private final RestTemplate restTemplate;

    // 생성자를 통해 RestTemplate을 주입받음
    public ChatGptService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * ChatGPT API 호출을 처리하는 메소드
     *
     * @param prompt 사용자 프롬프트
     * @return       ChatGptResponse 객체 (API 응답)
     */
    public ChatGptResponse getChatGptResponse(String prompt) {
        try {
            // ChatGptRequest 객체 생성
            ChatGptRequest request = new ChatGptRequest(model, prompt);

            // HTTP 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + apiKey);

            // HTTP 요청 엔티티 생성
            HttpEntity<ChatGptRequest> entity = new HttpEntity<>(request, headers);

            // API 호출 및 응답 받기
            ResponseEntity<ChatGptResponse> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, ChatGptResponse.class);
            logger.info("Received response from OpenAI API: {}", response.getBody());
            return response.getBody();
        } catch (Exception e) {
            // API 호출 중 오류 처리
            logger.error("Error occurred while calling OpenAI API", e);
            return null;
        }
    }
}
