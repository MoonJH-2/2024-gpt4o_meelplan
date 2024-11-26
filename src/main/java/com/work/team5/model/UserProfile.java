package com.work.team5.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * UserProfile 엔티티 클래스
 * - userprofile 테이블과 매핑됨
 * - 롬복(Lombok)을 사용하여 getter, setter 자동 생성
 */
@Entity
@Table(name = "userprofile")
@Getter
@Setter
public class UserProfile {

    /**
     * Primary Key로 사용되는 id 필드
     * - 자동 생성됨 (GenerationType.IDENTITY 사용)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 성별 필드
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String gender;

    /**
     * 나이 필드
     * - 기본값은 1
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private int age = 1;

    /**
     * 신장 필드 (cm)
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private double height;

    /**
     * 체중 필드 (kg)
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private double weight;

    /**
     * 기타 건강 상태 필드
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String healthConditions;

    /**
     * 식사 패턴 필드
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String mealPattern;

    /**
     * 식사 선호도 필드
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String foodPreferences;

    /**
     * 운동 빈도 필드 (예: 주 3회)
     * - 기본값은 빈 문자열
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String exerciseFrequency = "";

    /**
     * 운동 종류 필드 (예: 유산소, 근력 운동)
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String exerciseType;

    /**
     * 특정 건강 목표 필드 (예: 혈당 조절)
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String healthGoal;

    /**
     * User와의 관계 설정 (1:1 관계)
     * - 외래 키로 user_id를 사용하여 User 테이블의 id와 매핑
     */
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
