package bertos.net.shop;

import bertos.net.shop.model.Role;
import bertos.net.shop.model.Status;
import bertos.net.shop.model.User;
import bertos.net.shop.repository.RoleRepository;
import bertos.net.shop.services.UserServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 29.05.2020
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootConfiguration
@ContextConfiguration
public class TestUserCRUD extends AbstractTestCRUD<User, UserServiceImp> {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testCRUD() {

        Role roleUser = roleRepository.findByName("ROLE_USER");

        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        User user = new User();
        user.setUsername("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setPassword(passwordEncoder.encode("12345678"));
        user.setPasswordConfirm(passwordEncoder.encode("12345678"));
        user.setEmail("test@gmail.com");
        user.setPhone("89996669966");
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        init(user);
        run();
    }
}
