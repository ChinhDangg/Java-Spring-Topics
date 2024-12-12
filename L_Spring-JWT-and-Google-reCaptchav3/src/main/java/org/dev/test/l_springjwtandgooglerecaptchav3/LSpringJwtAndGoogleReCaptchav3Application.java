package org.dev.test.l_springjwtandgooglerecaptchav3;

import org.dev.test.l_springjwtandgooglerecaptchav3.security.RecaptchaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties(RecaptchaProperties.class)
public class LSpringJwtAndGoogleReCaptchav3Application {

    public static void main(String[] args) {
        SpringApplication.run(LSpringJwtAndGoogleReCaptchav3Application.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

}
