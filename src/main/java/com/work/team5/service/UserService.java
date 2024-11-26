package com.work.team5.service;

import com.work.team5.dto.UserDto;
import com.work.team5.model.User;
import com.work.team5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserService 클래스
 * - 사용자 관련 비즈니스 로직을 처리하는 서비스 클래스
 */
@Service
public class UserService {

    /**
     * UserRepository 인스턴스를 자동으로 주입받음
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * PasswordEncoder 인스턴스를 자동으로 주입받음
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 주어진 사용자 ID로 사용자 정보를 조회하는 메소드
     *
     * @param userid 조회할 사용자 ID
     * @return       조회된 사용자 객체 (없을 경우 null)
     */
    public User getUserByUserid(String userid) {
        return userRepository.findByUserid(userid);
    }

    /**
     * 새로운 사용자를 등록하는 메소드
     *
     * @param userDto 등록할 사용자 정보가 담긴 DTO 객체
     * @return        등록된 사용자 객체 (이미 존재하는 경우 null)
     */
    public User registerUser(UserDto userDto) {
        // 사용자 ID가 이미 존재하는지 확인
        if (userRepository.findByUserid(userDto.getUserid()) != null) {
            return null; // 사용자 ID가 이미 존재함
        }
        // 새로운 사용자 객체 생성 및 정보 설정
        User user = new User();
        user.setUserid(userDto.getUserid());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setName(userDto.getName());
        // 사용자 정보 저장 및 반환
        return userRepository.save(user);
    }
}
