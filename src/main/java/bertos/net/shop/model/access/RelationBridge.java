package bertos.net.shop.model.access;

import bertos.net.shop.model.access.Permission;
import bertos.net.shop.model.access.Role;
import bertos.net.shop.model.access.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 31.01.2021
 * @Description:
 */

@Entity
@Data
@Table(name = "users_roles")
public class RelationBridge {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private Role role;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "permission_id")
    @JsonBackReference
    private Permission permission;
}
