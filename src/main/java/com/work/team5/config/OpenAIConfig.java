package com.work.team5.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * OpenAIConfig 클래스
 * - OpenAI API와 관련된 설정을 정의하는 구성 클래스
 */
@Configuration
public class OpenAIConfig {

    // OpenAI API 키를 구성 파일에서 주입받음
    @Value("${openai.api.key}")
    String openaiApiKey;

    /**
     * RestTemplate 빈을 생성하는 메소드
     * - OpenAI API 호출 시 필요한 Authorization 헤더를 추가하는 Interceptor를 설정
     *
     * @return 설정된 RestTemplate 객체
     */
    @Bean
    public RestTemplate template(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }

    /**
     * WebMvcConfigurer 빈을 생성하는 메소드
     * - CORS 설정을 정의
     *
     * @return 설정된 WebMvcConfigurer 객체
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
