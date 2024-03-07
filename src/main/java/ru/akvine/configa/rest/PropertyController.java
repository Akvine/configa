package ru.akvine.configa.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.configa.enums.PropertyFileType;
import ru.akvine.configa.rest.converters.PropertyConverter;
import ru.akvine.configa.rest.dto.common.Response;
import ru.akvine.configa.rest.dto.common.SuccessfulResponse;
import ru.akvine.configa.rest.dto.property.AddPropertiesRequest;
import ru.akvine.configa.rest.dto.property.ListPropertiesRequest;
import ru.akvine.configa.rest.meta.PropertyControllerMeta;
import ru.akvine.configa.rest.validators.PropertyValidator;
import ru.akvine.configa.services.property.PropertyService;
import ru.akvine.configa.services.dto.property.AddProperties;
import ru.akvine.configa.services.dto.property.PropertyBean;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PropertyController implements PropertyControllerMeta {
    private final PropertyService propertyService;
    private final PropertyConverter propertyConverter;
    private final PropertyValidator propertyValidator;

    @Override
    public Response list(@Valid ListPropertiesRequest request) {
        List<PropertyBean> beans = propertyService.list(request.getAppUuid());
        return propertyConverter.convertToListPropertiesResponse(request.getAppUuid(), beans);
    }

    @Override
    public Response add(@Valid AddPropertiesRequest request) {
        AddProperties addProperties = propertyConverter.convertToAddProperties(request);
        propertyService.add(addProperties);
        return new SuccessfulResponse();
    }

    @Override
    public Response importProperties(String appUuid,
                                     String fileType,
                                     MultipartFile propertiesFile) {
        propertyValidator.verifyImportProperties(fileType, propertiesFile);
        AddProperties addProperties = propertyConverter.convertToAddProperties(appUuid, fileType, propertiesFile);
        propertyService.add(addProperties);
        return new SuccessfulResponse();
    }
}
