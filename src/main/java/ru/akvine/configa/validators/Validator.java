package ru.akvine.configa.validators;

public interface Validator<T> {
    void validate(T obj);
}
