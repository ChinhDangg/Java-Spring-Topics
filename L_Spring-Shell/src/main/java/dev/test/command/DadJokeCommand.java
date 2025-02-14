package dev.test.command;

import dev.test.client.DadJokeClient;
import dev.test.model.DadJokeResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DadJokeCommand {

    private final DadJokeClient dadJokeClient;

    public DadJokeCommand(DadJokeClient dadJokeClient) {
        this.dadJokeClient = dadJokeClient;
    }

    @ShellMethod(key = "random", value = "Return a random dad joke!")
    public String getRandomJoke() {
        DadJokeResponse response = dadJokeClient.random();
        return response.joke();
    }
}
