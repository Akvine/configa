package ru.akvine.configa.rest.meta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akvine.configa.rest.dto.app.AddAppRequest;
import ru.akvine.configa.rest.dto.app.ListAppRequest;
import ru.akvine.configa.rest.dto.common.Response;

import javax.validation.Valid;

@RequestMapping(value = "/app")
public interface AppControllerMeta {
    @PostMapping
    Response add(@Valid @RequestBody AddAppRequest request);

    @GetMapping
    Response list(@Valid @RequestBody ListAppRequest request);
}
