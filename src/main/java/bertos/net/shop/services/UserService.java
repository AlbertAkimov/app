package bertos.net.shop.services;

import bertos.net.shop.model.access.User;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
public interface UserService {

    User findByUsername(String username);

    User register(User user);

}
