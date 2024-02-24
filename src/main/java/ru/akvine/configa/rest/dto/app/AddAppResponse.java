package ru.akvine.configa.rest.dto.app;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.configa.rest.dto.common.SuccessfulResponse;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class AddAppResponse extends SuccessfulResponse {
    @NotNull
    private AppDto app;
}
