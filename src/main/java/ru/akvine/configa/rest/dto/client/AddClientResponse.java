package ru.akvine.configa.rest.dto.client;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.configa.rest.dto.common.SuccessfulResponse;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class AddClientResponse extends SuccessfulResponse {
    @NotBlank
    private String clientUuid;
    @NotBlank
    private String email;
}
