package ru.akvine.configa.entities.base;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@Accessors(chain = true)
public abstract class SoftBaseEntity extends BaseEntity {
    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

    @Column(name = "IS_DELETED", nullable = false)
    private boolean deleted;
}
