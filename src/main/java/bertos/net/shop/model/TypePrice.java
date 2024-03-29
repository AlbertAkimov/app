package bertos.net.shop.model;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */

@Entity
@Table(name = "type_prices")
@Data
//@Audited
public class TypePrice extends AbstractEntity {

    @Column(name = "name")
    private String name;
}
