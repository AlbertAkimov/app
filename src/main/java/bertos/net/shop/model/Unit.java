package bertos.net.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "units")
public class Unit extends AbstractEntity {

    @Column(name = "unit_name")
    private String unitName;
}
