package com.work.team5.service.meal;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.team5.dto.ChatGptResponse;
import com.work.team5.model.User;
import com.work.team5.model.meal.Meal;
import com.work.team5.model.meal.MealPlan;
import com.work.team5.model.meal.NutritionalInformation;
import com.work.team5.repository.meal.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MealPlanService 클래스
 * - 사용자별 식단 계획을 관리하는 서비스 클래스
 */
@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository mealPlanRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 주어진 사용자에 대한 최신 식단 계획을 조회하는 메소드
     *
     * @param user 사용자 객체
     * @return     최신 식단 계획 객체
     */
    public MealPlan findLatestMealPlanByUser(User user) {
        return mealPlanRepository.findTopByUserOrderByIdDesc(user);
    }

    /**
     * ChatGPT 응답에서 식단 계획을 추출하고 저장하는 메소드
     *
     * @param response ChatGPT 응답 객체
     * @param user     사용자 객체
     * @return         저장된 식단 계획 객체
     */
    public MealPlan saveMealPlanFromResponse(ChatGptResponse response, User user) {
        try {
            if (response != null && !response.getChoices().isEmpty()) {
                String content = response.getChoices().get(0).getMessage().getContent();
                // 응답 내용에서 JSON을 추출
                String jsonContent = extractJsonFromContent(content);

                JsonNode root = objectMapper.readTree(jsonContent);

                MealPlan mealPlan = new MealPlan();
                mealPlan.setUser(user);

                JsonNode breakfastNode = root.path("breakfast");
                if (!breakfastNode.isMissingNode()) {
                    mealPlan.setBreakfast(parseMeal(breakfastNode));
                }

                JsonNode lunchNode = root.path("lunch");
                if (!lunchNode.isMissingNode()) {
                    mealPlan.setLunch(parseMeal(lunchNode));
                }

                JsonNode dinnerNode = root.path("dinner");
                if (!dinnerNode.isMissingNode()) {
                    mealPlan.setDinner(parseMeal(dinnerNode));
                }

                JsonNode totalNutritionalInfoNode = root.path("totalDailyNutritionalInfo");
                if (!totalNutritionalInfoNode.isMissingNode()) {
                    mealPlan.setTotalDailyNutritionalInfo(parseTotalNutritionalInformation(totalNutritionalInfoNode));
                }

                return mealPlanRepository.save(mealPlan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 응답 내용에서 JSON 문자열을 추출하는 메소드
     *
     * @param content 응답 내용 문자열
     * @return        추출된 JSON 문자열
     */
    private String extractJsonFromContent(String content) {
        int jsonStart = content.indexOf("{");
        int jsonEnd = content.lastIndexOf("}");
        if (jsonStart != -1 && jsonEnd != -1) {
            return content.substring(jsonStart, jsonEnd + 1);
        }
        throw new IllegalArgumentException("Invalid JSON format in content");
    }

    /**
     * JSON 노드에서 Meal 객체를 파싱하는 메소드
     *
     * @param mealNode Meal 정보를 포함한 JSON 노드
     * @return         파싱된 Meal 객체
     */
    private Meal parseMeal(JsonNode mealNode) {
        Meal meal = new Meal();
        meal.setMealName(mealNode.path("mealName").asText());
        meal.setPortionSizes(mealNode.path("portionSizes").toString());
        meal.setNutritionalInformation(parseNutritionalInformation(mealNode.path("NutritionalInformation")));
        meal.setCaloricContent(mealNode.path("caloricContent").asInt());
        meal.setCookingMethod(mealNode.path("detailedCookingMethod").asText());
        return meal;
    }

    /**
     * JSON 노드에서 NutritionalInformation 객체를 파싱하는 메소드
     *
     * @param nutritionalInfoNode 영양 정보를 포함한 JSON 노드
     * @return                    파싱된 NutritionalInformation 객체
     */
    private NutritionalInformation parseNutritionalInformation(JsonNode nutritionalInfoNode) {
        NutritionalInformation nutritionalInfo = new NutritionalInformation();
        nutritionalInfo.setCarbs(nutritionalInfoNode.path("carbs").asInt());
        nutritionalInfo.setFat(nutritionalInfoNode.path("fat").asInt());
        nutritionalInfo.setProtein(nutritionalInfoNode.path("protein").asInt());
        return nutritionalInfo;
    }

    /**
     * JSON 노드에서 총 영양 정보를 파싱하는 메소드
     *
     * @param nutritionalInfoNode 총 영양 정보를 포함한 JSON 노드
     * @return                    파싱된 NutritionalInformation 객체
     */
    private NutritionalInformation parseTotalNutritionalInformation(JsonNode nutritionalInfoNode) {
        NutritionalInformation nutritionalInfo = new NutritionalInformation();
        nutritionalInfo.setCarbs(nutritionalInfoNode.path("total_carbs").asInt());
        nutritionalInfo.setFat(nutritionalInfoNode.path("total_fat").asInt());
        nutritionalInfo.setProtein(nutritionalInfoNode.path("total_protein").asInt());
        return nutritionalInfo;
    }
}
