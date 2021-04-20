package bertos.net.shop.repository;

import bertos.net.shop.model.access.UserPrivileges;

import java.util.List;

public interface UserPrivilegesRepository extends CRUDRepository<UserPrivileges> {

    List<UserPrivileges> findByUser_Id(Long id);
}
