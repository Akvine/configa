package ru.akvine.configa.rest.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.configa.exceptions.CommonErrorCodes;
import ru.akvine.configa.exceptions.validation.ValidationException;
import ru.akvine.configa.validators.PropertyFileTypeValidator;

@Component
@RequiredArgsConstructor
public class PropertyValidator {
    @Value("${properties.bytes.file.size.max}")
    private long bytesMaxSize;

    private final PropertyFileTypeValidator propertyFileTypeValidator;

    public void verifyImportProperties(String fileType, MultipartFile multipartFile) {
        propertyFileTypeValidator.validate(fileType);
        if (multipartFile.getSize() > bytesMaxSize) {
            throw new ValidationException(CommonErrorCodes.Validation.Property.PROPERTY_FILE_SIZE_ERROR,
                    "Property file is too large");
        }
    }
}
