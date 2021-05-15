package bertos.net.shop.services;

import bertos.net.shop.model.access.UserPrivileges;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

public interface UserPrivilegesService {

    List<UserPrivileges> findByUser_Id(Long id);
}
