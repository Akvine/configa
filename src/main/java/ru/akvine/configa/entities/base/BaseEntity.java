package ru.akvine.configa.entities.base;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@Accessors(chain = true)
public abstract class BaseEntity {
    @Column(name = "CREATED_DATE", nullable = false)
    private final LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
}
