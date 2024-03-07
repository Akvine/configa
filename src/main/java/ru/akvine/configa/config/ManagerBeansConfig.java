package ru.akvine.configa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.akvine.configa.enums.PropertyFileType;
import ru.akvine.configa.managers.PropertyParseManager;
import ru.akvine.configa.rest.converters.parser.PropertyFileParser;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Configuration
public class ManagerBeansConfig {

    @Bean
    public PropertyParseManager propertyParseManager(List<PropertyFileParser> parsers) {
        Map<PropertyFileType, PropertyFileParser> availableParsers = parsers
                .stream()
                .collect(toMap(PropertyFileParser::getType, identity()));
        return new PropertyParseManager(availableParsers);
    }
}
