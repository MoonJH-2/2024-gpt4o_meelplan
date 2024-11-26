package com.work.team5.repository;

import com.work.team5.model.User;
import com.work.team5.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserProfileRepository 인터페이스
 * - JpaRepository를 상속받아 기본 CRUD 메소드를 사용 가능
 * - 사용자 프로필 정보를 데이터베이스에서 조회, 저장 등을 수행하는 레포지토리
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    /**
     * 주어진 사용자(User) 객체로 사용자 프로필(UserProfile)을 조회하는 메소드
     *
     * @param user 조회할 사용자 객체
     * @return     조회된 사용자 프로필 객체 (없을 경우 null)
     */
    UserProfile findByUser(User user);
}
