package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 05.01.2022
 * @Description:
 */

@Entity
@Table(name = "products_of_order")
@Data
public class ProductsOfOrder extends AbstractEntity {

    @Column(name = "amt")
    private Double amt;

    @Column(name = "price")
    private Double price;

    @Column(name = "sum")
    private Double sum;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", referencedColumnName = "id")
    @JsonBackReference
    private Order order;

    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;
}
