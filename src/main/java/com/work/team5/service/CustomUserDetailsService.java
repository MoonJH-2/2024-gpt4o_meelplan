package com.work.team5.service;

import com.work.team5.model.User;
import com.work.team5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * CustomUserDetailsService 클래스
 * - 사용자 인증 정보를 제공하기 위한 서비스 클래스
 * - Spring Security의 UserDetailsService를 구현함
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    // UserRepository 인스턴스를 자동으로 주입받음
    @Autowired
    private UserRepository userRepository;

    /**
     * 주어진 사용자 ID로 사용자 정보를 로드하는 메소드
     *
     * @param userid 사용자 ID
     * @return       사용자 인증 정보 (UserDetails)
     * @throws UsernameNotFoundException 사용자 ID로 사용자를 찾을 수 없는 경우 발생
     */
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        // 사용자 ID로 사용자 조회
        User user = userRepository.findByUserid(userid);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with userid: " + userid);
        }
        // UserDetails 객체 생성 및 반환
        return org.springframework.security.core.userdetails.User.withUsername(user.getUserid())
                .password(user.getPassword())
                .authorities("USER")
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!user.isEnabled())
                .build();
    }
}
