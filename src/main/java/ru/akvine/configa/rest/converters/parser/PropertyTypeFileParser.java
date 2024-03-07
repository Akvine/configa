package ru.akvine.configa.rest.converters.parser;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.configa.enums.PropertyFileType;
import ru.akvine.configa.exceptions.property.PropertyParseException;
import ru.akvine.configa.services.dto.property.PropertyBean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyTypeFileParser implements PropertyFileParser {
    @Override
    public List<PropertyBean> parse(String appUuid, MultipartFile file) {
        List<PropertyBean> propertiesList = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("#") && line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String name = parts[0].trim();
                    String value = parts[1].trim();
                    propertiesList.add(new PropertyBean()
                            .setAppUuid(appUuid)
                            .setName(name)
                            .setValue(value));
                }
            }
        } catch (Exception exception) {
            throw new PropertyParseException("Can't parse property file with type = [" + getType() + "]. Message = " + exception.getMessage());
        }

        return propertiesList;
    }

    @Override
    public PropertyFileType getType() {
        return PropertyFileType.PROPERTIES;
    }
}
