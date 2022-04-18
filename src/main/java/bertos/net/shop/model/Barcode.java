package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 27.12.2020
 * @Description:
 */

@Table(name = "barcodes")
@Entity
@Data
//@Audited
public class Barcode extends AbstractEntity {

    @Column(name = "barcode")
    private String code;

    @Column(name = "type_barcode")
    @Enumerated(EnumType.STRING)
    private TypeBarcode typeBarcode;

    @Transient
    @JsonIgnore
    private String imageBarcode;

    @OneToOne(mappedBy = "barcode", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JsonBackReference
    private Product product;
}
