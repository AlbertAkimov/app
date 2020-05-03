package bertos.net.shop.model;

import lombok.Data;
import lombok.ToString;

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
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid_id")
    private String uuid_id;

    public AbstractEntity() {
        uuid_id = UUID.randomUUID().toString();
    }

    public Long getId() {
        return id;
    }

    public String getUuid_id() {
        return uuid_id;
    }

    public void setUuid_id(String uuid_id) {
        this.uuid_id = uuid_id;
    }
}
