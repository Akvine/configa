package ru.akvine.configa.services;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.configa.entities.AppEntity;
import ru.akvine.configa.entities.ClientEntity;
import ru.akvine.configa.exceptions.app.AppNotFoundException;
import ru.akvine.configa.repositories.AppRepository;
import ru.akvine.configa.services.dto.app.AppBean;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppRepository appRepository;
    private final AppUuidGeneratorService appUuidGeneratorService;
    private final ClientService clientService;

    public AppBean add(AppBean appBean) {
        Preconditions.checkNotNull(appBean, "appBean is null");

        ClientEntity clientEntity = clientService
                .findEntityByUuid(appBean.getClientUuid());
        AppEntity appEntity = new AppEntity()
                .setUuid(appUuidGeneratorService.generate())
                .setTitle(appBean.getTitle())
                .setClient(clientEntity);

        return new AppBean(appRepository.save(appEntity));
    }

    public List<AppBean> list(String clientUuid) {
        Preconditions.checkNotNull(clientUuid, "clientUuid is null");
        return appRepository
                .findByClientUuid(clientUuid)
                .stream()
                .map(AppBean::new)
                .collect(Collectors.toList());
    }

    public AppEntity findEntityByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        return appRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new AppNotFoundException("App with uuid = [" + uuid + "] not found!"));
    }
}
