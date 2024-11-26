package com.work.team5.repository;

import com.work.team5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository 인터페이스
 * - JpaRepository를 상속받아 기본 CRUD 메소드를 사용 가능
 * - 사용자 정보를 데이터베이스에서 조회, 저장 등을 수행하는 레포지토리
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 주어진 사용자 ID로 사용자 정보를 조회하는 메소드
     *
     * @param userid 조회할 사용자 ID
     * @return       조회된 사용자 객체 (없을 경우 null)
     */
    User findByUserid(String userid);
}
