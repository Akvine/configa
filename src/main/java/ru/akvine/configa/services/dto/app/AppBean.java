package ru.akvine.configa.services.dto.app;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.akvine.configa.entities.AppEntity;
import ru.akvine.configa.services.dto.client.ClientBean;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class AppBean {
    private Long id;
    private String uuid;
    private String clientUuid;
    private String title;
    private ClientBean clientBean;

    public AppBean(AppEntity appEntity) {
        this.id = appEntity.getId();
        this.uuid = appEntity.getUuid();
        this.title = appEntity.getTitle();
        this.clientBean = new ClientBean(appEntity.getClient());
    }
}
