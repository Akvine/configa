package ru.akvine.configa.utils;

import java.util.UUID;

public class UUIDGenerator {
    private final static int START_INDEX = 0;

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String uuid(int length) {
        return uuid().substring(START_INDEX, length);
    }

    public static String uuidWithoutDashes(int length) {
        return uuid(length).replaceAll("-", "");
    }
}
