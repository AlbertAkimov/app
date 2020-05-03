package bertos.net.shop.repository;

import bertos.net.shop.model.Role;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
public interface RoleRepository extends CRUD<Role> {

    Role findByName(String roleName);

}
