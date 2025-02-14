package dev.test.client;

import dev.test.model.DadJokeResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface DadJokeClient {

    @GetExchange("/")
    DadJokeResponse random();
}
