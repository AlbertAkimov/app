package bertos.net.shop.services;

import bertos.net.shop.model.Status;
import bertos.net.shop.model.access.Permission;
import bertos.net.shop.model.access.Role;
import bertos.net.shop.model.access.User;
import bertos.net.shop.model.access.UserPrivileges;
import bertos.net.shop.repository.RoleRepository;
import bertos.net.shop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */

@Slf4j
@Service
public class UserServiceImp extends AbstractCRUDServiceImpl<User, UserRepository>  {

    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository repository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        super(repository, User.class);
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username) {

        User user = repository.findByUsername(username);

        if(user != null)
            log.debug("user: " + username + " successfully found");

        return user;
    }

    public User register(User user) {

        List<Role> roles = roleRepository.findAll();
        List<UserPrivileges> privileges = new ArrayList<>();

        for(Role role : roles) {

            if(!role.getIsBase())
                continue;

            UserPrivileges userPrivileges = new UserPrivileges();
            userPrivileges.setRole(role);
            userPrivileges.setUser(user);

            Permission permission = new Permission();
            permission.setStatus(Status.ACTIVE);
            permission.setName("READ:" + role.getName().substring(5));

            userPrivileges.setPermission(permission);

            privileges.add(userPrivileges);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        user.setBridges(privileges);
        save(user);

        return user;
    }
}
