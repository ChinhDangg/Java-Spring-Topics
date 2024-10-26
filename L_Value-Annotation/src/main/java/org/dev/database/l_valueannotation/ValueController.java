package org.dev.database.l_valueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

    @Value("${greeting.salutation}")
    private String greeting;

    @Value("${greeting.salu:Default value}")
    private String defaultGreeting;

    @Value("${welcome.greeting}")
    private String welcome;

    @GetMapping
    public String[] greetings() {
        return new String[] { greeting, defaultGreeting, welcome };
    }
}
