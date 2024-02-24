package ru.akvine.configa.exceptions;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.akvine.configa.rest.dto.common.ErrorResponse;

@Component
@RequiredArgsConstructor
public class ErrorResponseBuilder {
    @Value("${pci.enabled}")
    private boolean pciEnabled;

    private static final String ERROR_DESCRIPTION_HIDDEN = "Description was hidden. Contact support.";

    public ErrorResponse build(String code, String description, String message) {
        return new ErrorResponse(
                code,
                pciEnabled || StringUtils.isBlank(description) ? ERROR_DESCRIPTION_HIDDEN : description,
                message);
    }

    public ErrorResponse build(String code, String message) {
        return build(code, null, message);
    }
}
