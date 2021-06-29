package bertos.net.shop.model.access;

import bertos.net.shop.model.AbstractEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 31.01.2021
 * @Description:
 */

@Entity
@Data
@Audited
@Table(name = "users_roles")
public class UserPrivileges extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "permission_id")
    private Permission permission;
}
