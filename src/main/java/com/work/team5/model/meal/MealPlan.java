package com.work.team5.model.meal;

import com.work.team5.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * MealPlan 엔티티 클래스
 * - meal_plan 테이블과 매핑됨
 * - 사용자별 식단 계획을 저장하는 클래스
 */
@Entity
@Table(name = "meal_plan")
@Getter
@Setter
@NoArgsConstructor
public class MealPlan {

    /**
     * Primary Key로 사용되는 id 필드
     * - 자동 생성됨 (GenerationType.IDENTITY 사용)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User와의 관계 설정 (다대일 관계)
     * - 외래 키로 user_id를 사용하여 User 테이블의 id와 매핑
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 아침 식사 필드
     * - 임베디드 타입으로 Meal 클래스를 사용
     * - 컬럼 이름을 별도로 지정하여 매핑
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "mealName", column = @Column(name = "breakfast_meal_name")),
            @AttributeOverride(name = "caloricContent", column = @Column(name = "breakfast_caloric_content")),
            @AttributeOverride(name = "cookingMethod", column = @Column(name = "breakfast_cooking_method")),
            @AttributeOverride(name = "portionSizes", column = @Column(name = "breakfast_portion_sizes")),
            @AttributeOverride(name = "nutritionalInformation.carbs", column = @Column(name = "breakfast_carbs")),
            @AttributeOverride(name = "nutritionalInformation.fat", column = @Column(name = "breakfast_fat")),
            @AttributeOverride(name = "nutritionalInformation.protein", column = @Column(name = "breakfast_protein"))
    })
    private Meal breakfast;

    /**
     * 점심 식사 필드
     * - 임베디드 타입으로 Meal 클래스를 사용
     * - 컬럼 이름을 별도로 지정하여 매핑
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "mealName", column = @Column(name = "lunch_meal_name")),
            @AttributeOverride(name = "caloricContent", column = @Column(name = "lunch_caloric_content")),
            @AttributeOverride(name = "cookingMethod", column = @Column(name = "lunch_cooking_method")),
            @AttributeOverride(name = "portionSizes", column = @Column(name = "lunch_portion_sizes")),
            @AttributeOverride(name = "nutritionalInformation.carbs", column = @Column(name = "lunch_carbs")),
            @AttributeOverride(name = "nutritionalInformation.fat", column = @Column(name = "lunch_fat")),
            @AttributeOverride(name = "nutritionalInformation.protein", column = @Column(name = "lunch_protein"))
    })
    private Meal lunch;

    /**
     * 저녁 식사 필드
     * - 임베디드 타입으로 Meal 클래스를 사용
     * - 컬럼 이름을 별도로 지정하여 매핑
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "mealName", column = @Column(name = "dinner_meal_name")),
            @AttributeOverride(name = "caloricContent", column = @Column(name = "dinner_caloric_content")),
            @AttributeOverride(name = "cookingMethod", column = @Column(name = "dinner_cooking_method")),
            @AttributeOverride(name = "portionSizes", column = @Column(name = "dinner_portion_sizes")),
            @AttributeOverride(name = "nutritionalInformation.carbs", column = @Column(name = "dinner_carbs")),
            @AttributeOverride(name = "nutritionalInformation.fat", column = @Column(name = "dinner_fat")),
            @AttributeOverride(name = "nutritionalInformation.protein", column = @Column(name = "dinner_protein"))
    })
    private Meal dinner;

    /**
     * 하루 총 영양 정보 필드
     * - 임베디드 타입으로 NutritionalInformation 클래스를 사용
     * - 컬럼 이름을 별도로 지정하여 매핑
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "carbs", column = @Column(name = "total_carbs")),
            @AttributeOverride(name = "fat", column = @Column(name = "total_fat")),
            @AttributeOverride(name = "protein", column = @Column(name = "total_protein"))
    })
    private NutritionalInformation totalDailyNutritionalInfo;
}
