package ru.akvine.configa.rest.meta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akvine.configa.rest.dto.common.Response;
import ru.akvine.configa.rest.dto.property.AddPropertiesRequest;
import ru.akvine.configa.rest.dto.property.ListPropertiesRequest;

import javax.validation.Valid;

@RequestMapping(value = "/properties")
public interface PropertyControllerMeta {
    @GetMapping
    Response list(@Valid @RequestBody ListPropertiesRequest request);

    @PostMapping
    Response add(@Valid @RequestBody AddPropertiesRequest request);
}
