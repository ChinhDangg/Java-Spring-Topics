package org.dev.database.l_springsecurityjwt.controller;

import org.dev.database.l_springsecurityjwt.config.SecurityConfig;
import org.dev.database.l_springsecurityjwt.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest({HomeController.class, AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
class HomeControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void rootWhenUnauthenticatedThen401() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    void rootWhenAuthenticatedTheySaysHelloUser() throws Exception {
        MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/token")
                .with(httpBasic("user", "password")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String token = result.getResponse().getContentAsString();

        this.mvc.perform(MockMvcRequestBuilders.get("/")
                .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.content().string("Hello user"));
    }

    @Test
    @WithMockUser
    public void rootWithMockUserStatusIsOk() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}