package ru.akvine.configa.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.akvine.configa.enums.PropertyFileType;
import ru.akvine.configa.exceptions.CommonErrorCodes;
import ru.akvine.configa.exceptions.validation.ValidationException;

@Component
public class PropertyFileTypeValidator implements Validator<String> {
    @Override
    public void validate(String type) {
        if (StringUtils.isBlank(type)) {
            throw new ValidationException(CommonErrorCodes.Validation.Property.PROPERTY_FILE_TYPE_BLANK_ERROR,
                    "Property file type is blank");
        }

        try {
            PropertyFileType.valueOf(type);
        } catch (Exception exception) {
            throw new ValidationException(CommonErrorCodes.Validation.Property.PROPERTY_FILE_TYPE_INVALID_ERROR,
                    "Property file type is invalid");
        }
    }
}
