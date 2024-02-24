package ru.akvine.configa.rest.converters;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.configa.rest.dto.property.AddPropertiesRequest;
import ru.akvine.configa.rest.dto.property.ListPropertiesResponse;
import ru.akvine.configa.rest.dto.property.PropertyDto;
import ru.akvine.configa.services.dto.property.AddProperties;
import ru.akvine.configa.services.dto.property.PropertyBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PropertyConverter {
    public AddProperties convertToAddProperties(AddPropertiesRequest request) {
        Preconditions.checkNotNull(request, "addPropertiesRequest is null");
        return new AddProperties()
                .setAppUuid(request.getAppUuid())
                .setProperties(buildPropetyBeans(request));
    }

    public ListPropertiesResponse convertToListPropertiesResponse(String appUuid,
                                                                  List<PropertyBean> propertyBeans) {
        Preconditions.checkNotNull(appUuid, "appUuid is null");
        Preconditions.checkNotNull(propertyBeans, "propertyBeans is null");
        return new ListPropertiesResponse()
                .setAppUuid(appUuid)
                .setProperties(buildPropertyDtos(propertyBeans));
    }

    private List<PropertyDto> buildPropertyDtos(List<PropertyBean> propertyBeans) {
        return propertyBeans
                .stream()
                .map(propertyBean -> new PropertyDto()
                        .setName(propertyBean.getName())
                        .setValue(propertyBean.getValue())
                        .setModifiable(propertyBean.isModifiable()))
                .collect(Collectors.toList());
    }

    private List<PropertyBean> buildPropetyBeans(AddPropertiesRequest request) {
        List<PropertyDto> properties = request.getProperties();
        return properties.
                stream()
                .map(propertyDto -> new PropertyBean()
                        .setAppUuid(request.getAppUuid())
                        .setModifiable(propertyDto.isModifiable())
                        .setName(propertyDto.getName())
                        .setValue(propertyDto.getValue()))
                .collect(Collectors.toList());
    }
}
