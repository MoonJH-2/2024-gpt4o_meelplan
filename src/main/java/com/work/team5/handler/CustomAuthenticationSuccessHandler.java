package com.work.team5.handler;

import com.work.team5.service.UserProfileService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * CustomAuthenticationSuccessHandler 클래스
 * - 사용자가 성공적으로 인증된 후의 동작을 정의하는 핸들러
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    // 로깅을 위한 Logger 인스턴스
    private static final Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class.getName());

    // UserProfileService 인스턴스를 주입받음
    private final UserProfileService userProfileService;

    // 생성자를 통해 UserProfileService를 주입받음
    public CustomAuthenticationSuccessHandler(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    /**
     * 인증 성공 시 호출되는 메소드
     *
     * @param request        HttpServletRequest 객체
     * @param response       HttpServletResponse 객체
     * @param authentication 인증 객체
     * @throws IOException, ServletException 예외 처리
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 인증된 사용자의 ID를 가져옴
        String userId = authentication.getName();

        // 사용자가 프로필을 가지고 있는지 확인
        if (userProfileService.hasUserProfile(userId)) {
            // 프로필이 있는 경우 홈 페이지로 리다이렉트
            response.sendRedirect("/users/home");
        } else {
            // 프로필이 없는 경우 프로필 생성 페이지로 리다이렉트
            response.sendRedirect("/profile/create");
        }

        // 로그인 성공 메시지 로깅
        logger.info("Login successful for user: " + userId);
    }
}
