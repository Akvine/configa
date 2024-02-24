package ru.akvine.configa.exceptions.app;

public class AppUuidGenerationLimitException extends RuntimeException {
    public AppUuidGenerationLimitException(String message) {
        super(message);
    }
}
