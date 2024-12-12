package org.dev.test.l_dependencyinjectionfortestability.model;

import java.time.LocalDateTime;

public record Article(Integer id, String title, String content, LocalDateTime publishDate) {
}
