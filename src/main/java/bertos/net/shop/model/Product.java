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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private ProductCategory productCategory;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parent")
    private List<Product> data;

}
