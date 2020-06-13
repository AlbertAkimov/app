package bertos.net.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Entity
@Table(name = "product_categories")
public class ProductCategory extends AbstractEntity {

    @Column(name = "id_parent")
    private Long parentId;

    @Column(name = "name")
    private String name;

/*
    @OneToMany(mappedBy = "productCategory", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<Product> products;
*/

}
