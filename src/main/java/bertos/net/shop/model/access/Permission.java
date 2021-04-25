package bertos.net.shop.model.access;

import bertos.net.shop.model.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @Authot: Albert Akimov
 * @Date: 30.01.2021
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "permissions")
@Data
@ToString
public class Permission extends AbstractEntity {

    @Column(name = "name")
    private String permission;

    @OneToMany(mappedBy = "permission",
            cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<UserPrivileges> bridges;

}
