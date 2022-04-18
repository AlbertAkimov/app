package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 05.01.2022
 * @Description:
 */

@Entity
@Table(name = "orders")
@Data
public class Order extends AbstractEntity {

    @Column(name = "total_sum")
    private Double totalSum;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card", referencedColumnName = "id")
    private Card card;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_owner", referencedColumnName = "id")
    @JsonManagedReference
    private Partner owner;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<ProductsOfOrder> products;

}
