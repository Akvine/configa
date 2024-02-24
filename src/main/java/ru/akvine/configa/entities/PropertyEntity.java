package ru.akvine.configa.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.akvine.configa.entities.base.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "PROPERTY_ENTITY")
@NoArgsConstructor
public class PropertyEntity extends BaseEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "propertyEntitySeq")
    @SequenceGenerator(name = "propertyEntitySeq", sequenceName = "SEQ_PROPERTY_ENTITY", allocationSize = 1000)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "IS_MODIFIABLE", nullable = false)
    private boolean modifiable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APP_ID", nullable = false)
    private AppEntity app;
}
