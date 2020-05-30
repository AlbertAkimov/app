package bertos.net.shop;

import bertos.net.shop.model.User;
import bertos.net.shop.services.impl.UserServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    public TestUserCRUD(UserServiceImp service) {
        super(service, new User());
    }

    @Test
    public void test_1() {
        runTest();
    }
}
