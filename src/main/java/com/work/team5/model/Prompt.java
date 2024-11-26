package com.work.team5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Prompt 엔티티 클래스
 * - prompts 테이블과 매핑됨
 * - 사용자 프롬프트와 그에 대한 응답을 저장하는 클래스
 */
@Entity
@Table(name = "prompts")
@Getter
@Setter
@NoArgsConstructor
public class Prompt {

    /**
     * Primary Key로 사용되는 id 필드
     * - 자동 생성됨 (GenerationType.IDENTITY 사용)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 프롬프트 텍스트 필드
     * - null 값을 허용하지 않음 (nullable = false)
     * - TEXT 타입으로 정의됨 (columnDefinition = "TEXT")
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String promptText;

    /**
     * 응답 텍스트 필드
     * - null 값을 허용하지 않음 (nullable = false)
     * - TEXT 타입으로 정의됨 (columnDefinition = "TEXT")
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String responseText;

    /**
     * 생성 날짜 및 시간 필드
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private LocalDateTime createdAt;

    /**
     * User와의 관계 설정 (다대일 관계)
     * - 외래 키로 user_id를 사용하여 User 테이블의 id와 매핑
     * - 지연 로딩 사용 (fetch = FetchType.LAZY)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 사용자, 프롬프트 텍스트, 응답 텍스트를 인자로 받아 객체를 생성하는 생성자
     * - 생성 시 createdAt 필드를 현재 시간으로 설정
     *
     * @param user        사용자 객체
     * @param promptText  프롬프트 텍스트
     * @param responseText 응답 텍스트
     */
    public Prompt(User user, String promptText, String responseText) {
        this.user = user;
        this.promptText = promptText;
        this.responseText = responseText;
        this.createdAt = LocalDateTime.now();
    }
}
