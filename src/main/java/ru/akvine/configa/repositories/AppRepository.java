package ru.akvine.configa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.configa.entities.AppEntity;

import java.util.Optional;

public interface AppRepository extends JpaRepository<AppEntity, Long> {
    @Query("from AppEntity ae where ae.uuid = :uuid " +
            "and ae.deletedDate is null and ae.deleted = false")
    Optional<AppEntity> findByUuid(@Param("uuid") String uuid);

    @Query("from AppEntity ae where ae.client.uuid = :uuid " +
            "and ae.deletedDate is null and ae.deleted = false " +
            "and ae.client.deletedDate is null and ae.client.deleted = false")
    Optional<AppEntity> findByClientUuid(@Param("uuid") String uuid);
}
