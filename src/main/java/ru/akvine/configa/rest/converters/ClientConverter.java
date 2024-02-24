package ru.akvine.configa.rest.converters;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.configa.rest.dto.client.AddClientRequest;
import ru.akvine.configa.rest.dto.client.AddClientResponse;
import ru.akvine.configa.services.dto.client.ClientBean;

@Component
public class ClientConverter {
    public ClientBean convertToClientBean(AddClientRequest request) {
        Preconditions.checkNotNull(request, "addClientRequest is null");
        return new ClientBean()
                .setEmail(request.getEmail());
    }

    public AddClientResponse convertToAddClientResponse(ClientBean clientBean) {
        Preconditions.checkNotNull(clientBean, "clientBean is null");
        return new AddClientResponse()
                .setClientUuid(clientBean.getUuid())
                .setEmail(clientBean.getEmail());
    }
}
