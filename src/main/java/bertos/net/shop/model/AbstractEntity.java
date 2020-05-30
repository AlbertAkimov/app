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

}
