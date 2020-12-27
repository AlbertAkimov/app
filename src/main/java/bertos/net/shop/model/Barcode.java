package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 27.12.2020
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "barcodes")
@Entity
@Data
@ToString
public class Barcode extends AbstractEntity {

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "type_barcode")
    @Enumerated(EnumType.STRING)
    private TypeBarcode typeBarcode;

    @OneToOne(mappedBy = "barcode", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Product product;
}
