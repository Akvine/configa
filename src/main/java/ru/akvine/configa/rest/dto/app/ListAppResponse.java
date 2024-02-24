package ru.akvine.configa.rest.dto.app;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.configa.rest.dto.common.SuccessfulResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Accessors(chain = true)
public class ListAppResponse extends SuccessfulResponse {
    @Valid
    @NotNull
    private List<AppDto> apps;
}
