package com.work.team5.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * UserDto 클래스
 * - 데이터 전송 객체(DTO)로 사용됨
 * - 롬복(Lombok)을 사용하여 getter, setter 자동 생성
 */
@Getter
@Setter
public class UserDto {
    /**
     * 유저 ID 필드
     * - getter, setter 자동 생성
     */
    private String userid;

    /**
     * 비밀번호 필드
     * - getter, setter 자동 생성
     */
    private String password;

    /**
     * 이름 필드
     * - getter, setter 자동 생성
     */
    private String name;
}
