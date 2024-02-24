package ru.akvine.configa.rest.dto.app;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AppDto {
    private String uuid;
    private String clientUuid;
    private String title;
}
