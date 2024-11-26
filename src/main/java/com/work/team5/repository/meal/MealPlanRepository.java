package com.work.team5.repository.meal;

import com.work.team5.model.User;
import com.work.team5.model.meal.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MealPlanRepository 인터페이스
 * - JpaRepository를 상속받아 기본 CRUD 메소드를 사용 가능
 * - 사용자 식단 계획을 데이터베이스에서 조회, 저장 등을 수행하는 레포지토리
 */
@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {

    /**
     * 주어진 사용자 ID로 모든 식단 계획을 조회하는 메소드
     *
     * @param userId 조회할 사용자 ID
     * @return       해당 사용자 ID의 모든 식단 계획 목록
     */
    List<MealPlan> findByUserId(Long userId);

    /**
     * 주어진 사용자에 대한 최신 식단 계획을 조회하는 메소드
     *
     * @param user 조회할 사용자 객체
     * @return     해당 사용자의 최신 식단 계획 객체
     */
    MealPlan findTopByUserOrderByIdDesc(User user);
}
