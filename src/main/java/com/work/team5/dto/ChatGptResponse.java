package com.work.team5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ChatGptResponse 클래스
 * - OpenAI의 ChatGPT API 응답을 저장하기 위한 데이터 전송 객체(DTO)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptResponse {

    /**
     * Choice 리스트 필드
     * - API 응답에서 선택된 결과 목록을 저장
     */
    private List<Choice> choices;

    /**
     * Choice 내부 클래스
     * - 각 선택된 결과를 저장하는 클래스
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {

        /**
         * 선택된 결과의 인덱스 필드
         */
        private int index;

        /**
         * 선택된 결과의 메시지 필드
         */
        private Message message;
    }

    /**
     * Message 내부 클래스
     * - 각 메시지를 저장하는 클래스
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Message {

        /**
         * 메시지 역할 필드
         * - 메시지를 보낸 주체의 역할을 나타냄 (예: 사용자, 시스템)
         */
        private String role;

        /**
         * 메시지 내용 필드
         * - 메시지 내용을 저장
         */
        private String content;
    }
}
