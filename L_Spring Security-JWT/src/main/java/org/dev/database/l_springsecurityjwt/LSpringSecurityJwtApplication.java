package org.dev.database.l_springsecurityjwt;

import org.dev.database.l_springsecurityjwt.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class LSpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(LSpringSecurityJwtApplication.class, args);
    }

}
