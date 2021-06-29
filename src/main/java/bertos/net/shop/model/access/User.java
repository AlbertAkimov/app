package bertos.net.shop.model.access;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.model.Status;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Authot: Albert Akimov
 * @Date: 15.03.2020
 * @Description:
 */

@Entity
@Data
@Audited
@Table(name = "users")
public class User extends AbstractEntity implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if(getBridges() != null) {
            for (UserPrivileges bridge : getBridges()) {
                if (bridge.getRole().getStatus() == Status.ACTIVE)
                    grantedAuthorities.add(new SimpleGrantedAuthority(bridge.getRole().getName()));
                if (bridge.getPermission() != null)
                    if (bridge.getPermission().getStatus() == Status.ACTIVE) {
                        grantedAuthorities.add(new SimpleGrantedAuthority(bridge.getPermission().getName()));
                    }
            }
        }
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
