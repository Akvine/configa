package ru.akvine.configa.rest.meta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.configa.rest.dto.common.Response;
import ru.akvine.configa.rest.dto.property.AddPropertiesRequest;
import ru.akvine.configa.rest.dto.property.ListPropertiesRequest;

import javax.validation.Valid;

@RequestMapping(value = "/properties")
public interface PropertyControllerMeta {
    @PostMapping("/list")
    Response list(@Valid @RequestBody ListPropertiesRequest request);

    @PostMapping("/add")
    Response add(@Valid @RequestBody AddPropertiesRequest request);

    @PostMapping("/import")
    Response importProperties(
            @RequestParam(value = "appUuid") String appUuid,
            @RequestParam(value = "converterType", defaultValue = "PROPERTIES") String fileType,
            @RequestParam(value = "file") MultipartFile propertiesFile);
}
