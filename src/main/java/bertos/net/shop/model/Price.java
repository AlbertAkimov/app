package bertos.net.shop.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */

@Entity
@Table(name = "prices")
@Data
@ToString
public class Price extends AbstractEntity {

    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_price")
    private TypePrice typePrice;

}
