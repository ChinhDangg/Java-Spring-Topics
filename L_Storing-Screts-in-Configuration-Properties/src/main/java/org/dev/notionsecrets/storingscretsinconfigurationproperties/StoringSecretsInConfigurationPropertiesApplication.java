package org.dev.notionsecrets.storingscretsinconfigurationproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NotionConfigProperties.class)
public class StoringSecretsInConfigurationPropertiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoringSecretsInConfigurationPropertiesApplication.class, args);
    }

}
