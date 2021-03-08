package bertos.net.shop.repository;

import bertos.net.shop.model.access.User;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
public interface UserRepository extends CRUDRepository<User> {

    User findByUsername(String username);

}
