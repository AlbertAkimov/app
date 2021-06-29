package bertos.net.shop.model.access;

import bertos.net.shop.model.AbstractEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 15.03.2020
 * @Description:
 */

@Entity
@Data
@Audited
@Table(name = "roles")
public class Role extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role",
            cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<UserPrivileges> bridges;
}
