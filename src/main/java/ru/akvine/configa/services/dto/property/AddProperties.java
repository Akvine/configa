package ru.akvine.configa.services.dto.property;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class AddProperties {
    private String appUuid;
    private List<PropertyBean> properties;
}
