package com.work.team5.service;

import com.work.team5.model.User;
import com.work.team5.model.UserProfile;
import com.work.team5.repository.UserProfileRepository;
import com.work.team5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserProfileService 클래스
 * - 사용자 프로필 관련 비즈니스 로직을 처리하는 서비스 클래스
 */
@Service
public class UserProfileService {

    // UserProfileRepository 인스턴스를 자동으로 주입받음
    @Autowired
    private UserProfileRepository userProfileRepository;

    // UserRepository 인스턴스를 자동으로 주입받음
    @Autowired
    private UserRepository userRepository;

    /**
     * 사용자 프로필을 저장하는 메소드
     *
     * @param userProfile 저장할 사용자 프로필 객체
     * @param userId      사용자 ID
     */
    public void saveUserProfile(UserProfile userProfile, String userId) {
        User user = userRepository.findByUserid(userId);
        if (user != null) {
            userProfile.setUser(user);
            userProfileRepository.save(userProfile);
        } else {
            throw new IllegalArgumentException("User not found with user_id: " + userId);
        }
    }

    /**
     * 사용자 프로필이 존재하는지 확인하는 메소드
     *
     * @param userId 사용자 ID
     * @return       사용자 프로필 존재 여부
     */
    public boolean hasUserProfile(String userId) {
        User user = userRepository.findByUserid(userId);
        if (user != null) {
            UserProfile userProfile = userProfileRepository.findByUser(user);
            return userProfile != null;
        }
        return false;
    }

    /**
     * 사용자 ID로 사용자 프로필을 조회하는 메소드
     *
     * @param userId 사용자 ID
     * @return       조회된 사용자 프로필 객체
     */
    public UserProfile getUserProfileByUserId(String userId) {
        User user = userRepository.findByUserid(userId);
        if (user != null) {
            return userProfileRepository.findByUser(user);
        } else {
            throw new IllegalArgumentException("User not found with user_id: " + userId);
        }
    }

    /**
     * 사용자 프로필을 업데이트하는 메소드
     *
     * @param updatedProfile 업데이트할 프로필 정보가 담긴 객체
     * @param userId         사용자 ID
     */
    public void updateUserProfile(UserProfile updatedProfile, String userId) {
        User user = userRepository.findByUserid(userId);
        if (user != null) {
            UserProfile existingProfile = userProfileRepository.findByUser(user);
            if (existingProfile != null) {
                existingProfile.setGender(updatedProfile.getGender());
                existingProfile.setAge(updatedProfile.getAge());
                existingProfile.setHeight(updatedProfile.getHeight());
                existingProfile.setWeight(updatedProfile.getWeight());
                existingProfile.setHealthConditions(updatedProfile.getHealthConditions());
                existingProfile.setMealPattern(updatedProfile.getMealPattern());
                existingProfile.setFoodPreferences(updatedProfile.getFoodPreferences());
                existingProfile.setExerciseFrequency(updatedProfile.getExerciseFrequency());
                existingProfile.setExerciseType(updatedProfile.getExerciseType());
                existingProfile.setHealthGoal(updatedProfile.getHealthGoal());

                userProfileRepository.save(existingProfile);
            } else {
                throw new IllegalArgumentException("UserProfile not found for user_id: " + userId);
            }
        } else {
            throw new IllegalArgumentException("User not found with user_id: " + userId);
        }
    }
}
