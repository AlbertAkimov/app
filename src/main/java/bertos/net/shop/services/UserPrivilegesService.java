package bertos.net.shop.services;

import bertos.net.shop.model.access.UserPrivileges;

import java.util.List;

public interface UserPrivilegesService {

    List<UserPrivileges> findByUser_Id(Long id);
}
