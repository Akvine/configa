package ru.akvine.configa.enums;

public enum PropertyFileType {
    PROPERTIES("properties");

    public String value;

    PropertyFileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
