package ru.akvine.configa.rest.dto.property;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class PropertiesRequest {
    @NotBlank
    private String appUuid;
}
