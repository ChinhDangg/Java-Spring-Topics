package org.dev.backend.l_springdatajdbcdataaccess.model.dto;

import org.dev.backend.l_springdatajdbcdataaccess.model.Author;
import org.dev.backend.l_springdatajdbcdataaccess.model.Post;

public record PostDetails(Post post, Author author) {
}
