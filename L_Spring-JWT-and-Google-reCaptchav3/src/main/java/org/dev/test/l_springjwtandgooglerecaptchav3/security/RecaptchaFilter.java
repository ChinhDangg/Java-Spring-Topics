package org.dev.test.l_springjwtandgooglerecaptchav3.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dev.test.l_springjwtandgooglerecaptchav3.model.RecaptchaResponse;
import org.dev.test.l_springjwtandgooglerecaptchav3.service.RecaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class RecaptchaFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(RecaptchaFilter.class);

    private final RecaptchaService recaptchaService;

    public RecaptchaFilter(RecaptchaService recaptchaService) {
        this.recaptchaService = recaptchaService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("RecaptchaFilter doFilter");
        if (request.getMethod().equals("POST")) {
            String recaptcha = request.getHeader("recaptcha");
            if (recaptcha == null || recaptcha.isBlank()) {
                logger.error("Missing recaptcha token");
                throw new BadCredentialsException("Missing recaptcha token");
            }
            RecaptchaResponse recaptchaResponse = recaptchaService.validateToken(recaptcha);
            if (!recaptchaResponse.success()) {
                logger.info("Invalid Recaptcha token");
                throw new BadCredentialsException("Invalid Recaptcha token");
            }
            // add recaptcha response score check 0.0 -> 1.0
        }

        filterChain.doFilter(request, response);
    }
}
