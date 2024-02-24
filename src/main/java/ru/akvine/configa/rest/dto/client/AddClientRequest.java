package ru.akvine.configa.rest.dto.client;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class AddClientRequest {
    @NotBlank
    private String email;
}
