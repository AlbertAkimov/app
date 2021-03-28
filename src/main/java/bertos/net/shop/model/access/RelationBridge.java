package bertos.net.shop.model.access;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.model.access.Permission;
import bertos.net.shop.model.access.Role;
import bertos.net.shop.model.access.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 31.01.2021
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "users_roles")
public class RelationBridge extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "permission_id")
    private Permission permission;
}
