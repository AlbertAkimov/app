package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "unit", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    //@JsonManagedReference
    private Product product;
}
