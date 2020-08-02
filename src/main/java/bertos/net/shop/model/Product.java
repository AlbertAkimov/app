package bertos.net.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@Data
@ToString
public class Product extends AbstractEntity {

    @Column(name = "id_parent")
    private Long parentId;

    @Column(name = "is_group")
    private boolean isGroup;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_product")
    private TypeProduct typeProduct;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parent")
    private List<Product> data;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<Price> prices;

}
