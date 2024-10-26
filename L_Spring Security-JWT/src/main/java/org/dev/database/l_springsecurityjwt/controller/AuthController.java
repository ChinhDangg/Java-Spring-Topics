package org.dev.database.l_springsecurityjwt.controller;

import org.dev.database.l_springsecurityjwt.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    // http POST :8080/token --auth user:password -v
    //  http :8080 'Authorization: Bearer token-here'

    @PostMapping("/token")
    public String getToken(Authentication authentication) {
        LOGGER.debug("Token request for user _{}", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOGGER.debug("Token generated {}", token);
        return token;
    }
}
