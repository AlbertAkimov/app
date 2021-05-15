package bertos.net.shop.model;

import lombok.Data;
import lombok.ToString;

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
@ToString
public class TypePrice extends AbstractEntity {

    @Column(name = "name")
    private String name;
}
