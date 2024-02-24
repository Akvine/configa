package ru.akvine.configa.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.configa.exceptions.app.AppUuidGenerationLimitException;
import ru.akvine.configa.repositories.AppRepository;

@Service
@RequiredArgsConstructor
public class AppUuidGeneratorService {
    private final AppRepository appRepository;

    @Value("${app.uuid.length}")
    private int length;
    @Value("${app.uuid.max.length.generation.attempts}")
    private int maxAttempts;

    public String generate() {
        for (int i = 0; i < maxAttempts; ++i) {
            String code = RandomStringUtils.randomNumeric(length);
            boolean exists = appRepository.findByUuid(code).isPresent();

            if (!exists) {
                return code;
            }
        }

        throw new AppUuidGenerationLimitException("Attempts to generate app UUID have been exhausted!");
    }
}
