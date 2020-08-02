package bertos.net.shop.services;

import bertos.net.shop.model.Role;
import bertos.net.shop.model.Status;
import bertos.net.shop.model.User;
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
public class UserServiceImp extends AbstractCRUDServiceImpl<User, UserRepository> implements UserService {

    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository repository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        super(repository, User.class);
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {

        User user = repository.findByUsername(username);

        if(user != null)
            log.debug("user: " + username + " successfully found");

        return user;
    }

    @Override
    public User register(User user) {

        Role roleUser = roleRepository.findByName("ROLE_USER");

        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        save(user);

        return user;
    }
}
