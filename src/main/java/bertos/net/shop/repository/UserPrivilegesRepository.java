package bertos.net.shop.repository;

import bertos.net.shop.model.access.UserPrivileges;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

public interface UserPrivilegesRepository extends CRUDRepository<UserPrivileges> {

    List<UserPrivileges> findByUser_Id(Long id);
}
