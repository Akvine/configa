package ru.akvine.configa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.configa.entities.PropertyEntity;

import java.util.List;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
    @Query("from PropertyEntity pe where pe.app.uuid = :uuid " +
            "and pe.app.deleted = false and pe.app.deletedDate is null")
    List<PropertyEntity> list(@Param("uuid") String uuid);
}
