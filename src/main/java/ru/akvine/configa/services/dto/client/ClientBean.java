package ru.akvine.configa.services.dto.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.akvine.configa.entities.ClientEntity;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ClientBean {
    private Long id;
    private String uuid;
    @ToString.Exclude
    private String email;

    public ClientBean(ClientEntity clientEntity) {
        this.id = clientEntity.getId();
        this.uuid = clientEntity.getUuid();
        this.email = clientEntity.getEmail();
    }
}
