package ru.akvine.configa.rest.meta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akvine.configa.rest.dto.client.AddClientRequest;
import ru.akvine.configa.rest.dto.common.Response;

import javax.validation.Valid;

@RequestMapping(value = "/clients")
public interface ClientControllerMeta {
    @PostMapping
    Response add(@Valid @RequestBody AddClientRequest request);
}
