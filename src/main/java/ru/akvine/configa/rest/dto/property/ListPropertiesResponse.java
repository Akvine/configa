package ru.akvine.configa.rest.dto.property;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.configa.rest.dto.common.SuccessfulResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Accessors(chain = true)
public class ListPropertiesResponse extends SuccessfulResponse {
    @NotBlank
    private String appUuid;

    @NotNull
    @Valid
    private List<PropertyDto> properties;
}
