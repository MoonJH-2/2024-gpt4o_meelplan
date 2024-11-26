package com.work.team5.model.meal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Meal 클래스
 * - 임베디드 타입으로 사용됨
 * - 식사 관련 정보를 저장하는 클래스
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Meal {

    /**
     * 식사 이름 필드
     */
    private String mealName;

    /**
     * 식사 재료 리스트 필드
     * - 컬렉션 타입으로 정의됨
     * - meal_ingredients 테이블에 저장됨
     * - meal_id 컬럼을 외래 키로 사용하여 연결됨
     */
    @ElementCollection
    @CollectionTable(name = "meal_ingredients", joinColumns = @JoinColumn(name = "meal_id"))
    @Column(name = "ingredient")
    private List<String> ingredients;

    /**
     * 영양 정보 필드
     * - NutritionalInformation 임베디드 타입으로 정의됨
     */
    @Embedded
    private NutritionalInformation nutritionalInformation;

    /**
     * 칼로리 함량 필드
     */
    private int caloricContent;

    /**
     * 요리 방법 필드
     */
    private String cookingMethod;

    /**
     * 1인분 크기 필드
     */
    private String portionSizes;
}
