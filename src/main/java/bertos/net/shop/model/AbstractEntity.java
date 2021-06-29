package bertos.net.shop.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Authot: Albert Akimov
 * @Date: 21.02.2020
 * @Description:
 */

@MappedSuperclass
@Data
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "guid")
    protected String guid;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public AbstractEntity() {
        if(this.guid == null)
            guid = UUID.randomUUID().toString();
    }

}
