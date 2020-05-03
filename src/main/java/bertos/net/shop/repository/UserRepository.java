package bertos.net.shop.repository;

import bertos.net.shop.model.User;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
public interface UserRepository extends CRUD<User> {

    User findByUsername(String username);

}
