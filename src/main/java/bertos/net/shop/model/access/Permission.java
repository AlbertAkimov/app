package bertos.net.shop.model.access;

import bertos.net.shop.model.AbstractEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 30.01.2021
 * @Description:
 */

@Entity
@Table(name = "permissions")
@Data
@ToString
public class Permission extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "permission",
            cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<UserPrivileges> bridges;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return name.equals(that.name);
    }
}
