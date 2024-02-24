package ru.akvine.configa.services;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.configa.entities.AppEntity;
import ru.akvine.configa.entities.PropertyEntity;
import ru.akvine.configa.repositories.PropertyRepository;
import ru.akvine.configa.services.dto.property.AddProperties;
import ru.akvine.configa.services.dto.property.PropertyBean;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final AppService appService;

    public void add(AddProperties addProperties) {
        Preconditions.checkNotNull(addProperties, "addProperties is null");

        AppEntity appEntity = appService.findEntityByUuid(addProperties.getAppUuid());
        addProperties.getProperties().forEach(property -> {
            PropertyEntity propertyEntity = new PropertyEntity()
                    .setApp(appEntity)
                    .setName(property.getName())
                    .setValue(property.getValue())
                    .setModifiable(property.isModifiable());
            propertyRepository.save(propertyEntity);
        });

    }

    public List<PropertyBean> list(String appUuid) {
        Preconditions.checkNotNull(appUuid, "appUuid is null");
        return propertyRepository
                .list(appUuid)
                .stream()
                .map(PropertyBean::new)
                .collect(Collectors.toList());
    }
}
