package com.work.team5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Message 클래스
 * - 데이터 전송 객체(DTO)로 사용됨
 * - 롬복(Lombok)을 사용하여 getter, setter, toString, equals, hashCode 메소드 자동 생성
 * - 모든 필드를 포함한 생성자와 기본 생성자 자동 생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    /**
     * 메시지 역할 필드
     * - 메시지를 보낸 주체의 역할을 나타냄 (예: 사용자, 시스템)
     */
    private String role;

    /**
     * 메시지 내용 필드
     * - 프롬프트 내용을 저장
     */
    private String content; // prompt
}
