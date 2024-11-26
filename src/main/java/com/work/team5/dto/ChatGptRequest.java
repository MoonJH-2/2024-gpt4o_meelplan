package com.work.team5.dto;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * ChatGptRequest 클래스
 * - OpenAI의 ChatGPT API 요청을 구성하기 위한 데이터 전송 객체(DTO)
 */
@Data
public class ChatGptRequest {
    // 로깅을 위한 Logger 인스턴스
    private static final Logger logger = LoggerFactory.getLogger(ChatGptRequest.class);

    /**
     * 모델 이름 필드
     * - 사용할 모델의 이름을 저장
     */
    private String model;

    /**
     * 메시지 리스트 필드
     * - API 요청에 포함될 메시지 목록을 저장
     */
    private List<Message> messages;

    /**
     * 모델 이름과 프롬프트를 인자로 받아 객체를 생성하는 생성자
     * - 메시지 리스트를 초기화하고, 프롬프트를 포함한 메시지를 추가
     * - 생성 시 로깅
     *
     * @param model  사용할 모델의 이름
     * @param prompt 사용자 프롬프트
     */
    public ChatGptRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt == null ? "" : prompt));
        logger.info("ChatGptRequest with prompt: {}", prompt);
    }
}
