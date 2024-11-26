package com.work.team5.model.meal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * NutritionalInformation 클래스
 * - 임베디드 타입으로 사용됨
 * - 영양 정보를 저장하는 클래스
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class NutritionalInformation {

    /**
     * 탄수화물 함량 필드 (g)
     */
    private int carbs;

    /**
     * 지방 함량 필드 (g)
     */
    private int fat;

    /**
     * 단백질 함량 필드 (g)
     */
    private int protein;
}
