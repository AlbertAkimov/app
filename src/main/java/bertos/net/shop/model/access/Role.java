package bertos.net.shop.model.access;

import bertos.net.shop.model.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 15.03.2020
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "roles")
public class Role extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role",
            cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<UserPrivileges> bridges;
}
