package bertos.net.shop.model;

import bertos.net.shop.audit.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "guid")
    protected String guid;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public AbstractEntity() {
        guid = UUID.randomUUID().toString();
    }

}
