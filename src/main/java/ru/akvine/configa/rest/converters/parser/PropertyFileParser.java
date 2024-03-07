package ru.akvine.configa.rest.converters.parser;

import org.springframework.web.multipart.MultipartFile;
import ru.akvine.configa.enums.PropertyFileType;
import ru.akvine.configa.services.dto.property.PropertyBean;

import java.util.List;

public interface PropertyFileParser {
    List<PropertyBean> parse(String appUuid, MultipartFile file);

    PropertyFileType getType();
}
