package ru.akvine.configa.rest.dto.property;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PropertyDto {
    private String name;
    private String value;
    private boolean modifiable;
}
