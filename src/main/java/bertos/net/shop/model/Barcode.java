package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
    //@JsonManagedReference
    private Product product;
}
