package com.work.team5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * SecurityConfig 클래스
 * - 애플리케이션의 보안 설정을 정의하는 구성 클래스
 */
@Configuration
public class SecurityConfig {

    // 커스텀 인증 성공 핸들러 인스턴스를 주입받음
    private final AuthenticationSuccessHandler customAuthenticationSuccessHandler;

    // 생성자를 통해 customAuthenticationSuccessHandler를 주입받음
    public SecurityConfig(AuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    /**
     * SecurityFilterChain 빈을 생성하는 메소드
     * - HTTP 보안 설정을 정의
     *
     * @param http HttpSecurity 객체
     * @return     설정된 SecurityFilterChain 객체
     * @throws Exception 설정 중 발생할 수 있는 예외
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // CSRF 보호 비활성화
                .authorizeRequests()
                .antMatchers("/", "/users/register", "/users/login", "/static/**", "/css/**", "/js/**", "/img/**", "/scss/**", "/fonts/**").permitAll() // 특정 경로에 대한 접근 허용
                .anyRequest().authenticated()  // 기타 모든 요청은 인증 필요
                .and()
                .formLogin()
                .loginPage("/users/login")  // 사용자 정의 로그인 페이지 설정
                .usernameParameter("userid")  // 사용자 이름 파라미터 설정
                .passwordParameter("password")  // 비밀번호 파라미터 설정
                .loginProcessingUrl("/users/login")  // 로그인 처리 URL 설정
                .successHandler(customAuthenticationSuccessHandler)  // 인증 성공 핸들러 설정
                .permitAll()
                .and()
                .logout()
                .permitAll();  // 로그아웃 허용
        return http.build();
    }

    /**
     * PasswordEncoder 빈을 생성하는 메소드
     * - 비밀번호 암호화를 위한 BCryptPasswordEncoder 객체를 빈으로 등록
     *
     * @return BCryptPasswordEncoder 객체
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
