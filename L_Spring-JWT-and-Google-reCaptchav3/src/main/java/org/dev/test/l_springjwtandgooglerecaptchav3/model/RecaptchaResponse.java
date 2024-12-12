package org.dev.test.l_springjwtandgooglerecaptchav3.model;

public record RecaptchaResponse(
        Boolean success,
        String challenge_ts,
        String hostname,
        Double score,
        String action
) {
}
