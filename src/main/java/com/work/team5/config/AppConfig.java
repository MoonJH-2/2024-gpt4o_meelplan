package com.work.team5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * AppConfig 클래스
 * - 애플리케이션 전역 설정을 정의하는 구성 클래스
 */
@Configuration
public class AppConfig {

    /**
     * RestTemplate 빈을 생성하는 메소드
     * - HTTP 요청을 간편하게 보내기 위한 RestTemplate 객체를 빈으로 등록
     *
     * @return RestTemplate 객체
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
