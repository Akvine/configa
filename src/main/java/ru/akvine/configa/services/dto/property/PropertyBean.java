package ru.akvine.configa.services.dto.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.akvine.configa.entities.PropertyEntity;
import ru.akvine.configa.services.dto.app.AppBean;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PropertyBean {
    private Long id;
    private String appUuid;
    private String name;
    private String value;
    private boolean modifiable;
    private AppBean appBean;

    public PropertyBean(PropertyEntity propertyEntity) {
        this.id = propertyEntity.getId();
        this.name = propertyEntity.getName();
        this.value = propertyEntity.getValue();
        this.modifiable = propertyEntity.isModifiable();
        this.appBean = new AppBean(propertyEntity.getApp());
    }
}
