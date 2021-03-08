package bertos.net.shop.repository;

import bertos.net.shop.model.access.Role;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
public interface RoleRepository extends CRUDRepository<Role> {

    Role findByName(String roleName);

}
