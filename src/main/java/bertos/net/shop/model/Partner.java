package bertos.net.shop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 05.01.2022
 * @Description:
 */

@Entity
@Table(name = "partners")
@Data
public class Partner extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "partner", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Card> cards;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Order> orders;

}
