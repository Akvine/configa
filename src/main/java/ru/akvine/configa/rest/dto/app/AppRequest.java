package ru.akvine.configa.rest.dto.app;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class AppRequest {
    @NotBlank
    private String clientUuid;
}
