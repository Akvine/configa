package ru.akvine.configa.rest.dto.property;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Accessors(chain = true)
public class AddPropertiesRequest extends PropertiesRequest {
    @NotNull
    private List<PropertyDto> properties;
}
