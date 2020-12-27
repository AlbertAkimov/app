package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "prices")
@Data
@ToString
public class Price extends AbstractEntity {

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    @JsonBackReference
    private Product product;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_price")
    private TypePrice typePrice;

}
