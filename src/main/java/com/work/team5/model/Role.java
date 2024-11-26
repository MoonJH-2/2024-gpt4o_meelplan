package com.work.team5.model;

import lombok.*;

import javax.persistence.*;

/**
 * Role 엔티티 클래스
 * - roles 테이블과 매핑됨
 * - 사용자 역할을 저장하는 클래스
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

    /**
     * Primary Key로 사용되는 id 필드
     * - 자동 생성됨 (GenerationType.IDENTITY 사용)
     * - equals 및 hashCode 메소드에 포함됨
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    /**
     * 역할 이름 필드
     * - null 값을 허용하지 않음 (nullable = false)
     * - 고유해야 함 (unique = true)
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * 역할 이름을 인자로 받아 객체를 생성하는 빌더 생성자
     *
     * @param name 역할 이름
     */
    @Builder
    public Role(String name) {
        this.name = name;
    }
}
