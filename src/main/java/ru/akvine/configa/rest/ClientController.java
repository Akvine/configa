package ru.akvine.configa.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.configa.rest.converters.ClientConverter;
import ru.akvine.configa.rest.dto.client.AddClientRequest;
import ru.akvine.configa.rest.dto.common.Response;
import ru.akvine.configa.rest.meta.ClientControllerMeta;
import ru.akvine.configa.services.ClientService;
import ru.akvine.configa.services.dto.client.ClientBean;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientControllerMeta {
    private final ClientService clientService;
    private final ClientConverter clientConverter;

    @Override
    public Response add(@Valid AddClientRequest request) {
        ClientBean clientBeanToAdd = clientConverter.convertToClientBean(request);
        ClientBean clientBean = clientService.add(clientBeanToAdd);
        return clientConverter.convertToAddClientResponse(clientBean);
    }
}
