package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */

@Entity
@Table(name = "products")
@Data
@ToString
public class Product extends AbstractEntity {

    @Column(name = "id_parent")
    private Long parentId;

    @Column(name = "is_group")
    private Boolean isGroup;

    @Column(name = "level_group")
    private Integer levelGroup;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_product")
    private TypeProduct typeProduct;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parent")
    @OrderBy(value = "isGroup DESC")
    private List<Product> data;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Price> prices;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unit", referencedColumnName = "id")
    @OrderColumn
    private Unit unit;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barcode", referencedColumnName = "id")
    @OrderColumn
    private Barcode barcode;
}
