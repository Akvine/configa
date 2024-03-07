package ru.akvine.configa.managers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.configa.enums.PropertyFileType;
import ru.akvine.configa.rest.converters.parser.PropertyFileParser;

import java.util.Map;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class PropertyParseManager {
    private Map<PropertyFileType, PropertyFileParser> propertyFileParsers;
}
