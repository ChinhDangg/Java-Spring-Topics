package org.dev.test.l_springjwtandgooglerecaptchav3.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "recaptcha")
public record RecaptchaProperties(String verifyUrl, String secretKey) {
}
