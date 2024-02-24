package ru.akvine.configa.services;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.configa.entities.ClientEntity;
import ru.akvine.configa.exceptions.client.ClientNotFoundException;
import ru.akvine.configa.repositories.ClientRepository;
import ru.akvine.configa.services.dto.client.ClientBean;
import ru.akvine.configa.utils.UUIDGenerator;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Value("${uuid.length}")
    private int uuidLength;

    public ClientBean add(ClientBean clientBean) {
        Preconditions.checkNotNull(clientBean, "clientBean is null");
        ClientEntity clientEntity = new ClientEntity()
                .setUuid(UUIDGenerator.uuidWithoutDashes(uuidLength))
                .setEmail(clientBean.getEmail());
        return new ClientBean(clientRepository.save(clientEntity));
    }

    public ClientEntity findEntityByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        return clientRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new ClientNotFoundException("Client with uuid = [" + uuid + "] not found!"));
    }
}
