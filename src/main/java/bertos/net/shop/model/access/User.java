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
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "password_confirm")
    private String passwordConfirm;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE})
    private List<UserPrivileges> bridges;
}
