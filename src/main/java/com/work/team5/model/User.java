package com.work.team5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * User 엔티티 클래스
 * - users 테이블과 매핑됨
 * - 롬복(Lombok)을 사용하여 getter, setter, 기본 생성자 자동 생성
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    /**
     * Primary Key로 사용되는 id 필드
     * - 자동 생성됨 (GenerationType.IDENTITY 사용)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 유저 ID 필드
     * - null 값을 허용하지 않음 (nullable = false)
     * - 고유해야 함 (unique = true)
     */
    @Column(nullable = false, unique = true)
    private String userid;

    /**
     * 비밀번호 필드
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String password;

    /**
     * 이름 필드
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private String name;

    /**
     * 활성화 상태를 나타내는 필드
     * - 기본값은 true
     * - null 값을 허용하지 않음 (nullable = false)
     */
    @Column(nullable = false)
    private boolean enabled = true;

    /**
     * UserProfile 엔티티와 일대일 관계를 맺는 필드
     * - 이 필드는 UserProfile 엔티티에 의해 매핑됨 (mappedBy = "user")
     * - 모든 CRUD 작업에 대해 전이됨 (CascadeType.ALL)
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;
}
