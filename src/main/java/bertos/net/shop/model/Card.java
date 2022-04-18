package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 05.01.2022
 * @Description:
 */

@Entity
@Table(name = "cards")
@Data
public class Card extends AbstractEntity {

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeCard type;

    @Column(name = "percent")
    private Integer percent;

    @Column(name = "accumulation")
    private Long accumulation;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_owner", referencedColumnName = "id")
    @JsonBackReference
    private Partner partner;

}
