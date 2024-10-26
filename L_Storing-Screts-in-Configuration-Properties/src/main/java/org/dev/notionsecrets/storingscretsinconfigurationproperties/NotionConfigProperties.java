package org.dev.notionsecrets.storingscretsinconfigurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("notion")
// properties that we want to expose as configuration properties
public record NotionConfigProperties(String apiUrl, String apiVersion, String authToken, String databaseId) {
}
