package org.dev.database.l_restapitodoservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Todo(@Id Integer id, Integer userId, String title, boolean completed, @Version Integer version) {
}
