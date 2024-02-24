package ru.akvine.configa.services.dto.base;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public abstract class Bean {
    protected LocalDateTime createdDate;
    @Nullable
    protected LocalDateTime updatedDate;
}
