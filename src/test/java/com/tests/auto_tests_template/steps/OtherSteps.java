package com.tests.auto_tests_template.steps;

import io.cucumber.java.ru.Если;

import java.time.Duration;

public class OtherSteps {
    @Если("Подождать {long} секунд")
    public void waitUntil(Long seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
