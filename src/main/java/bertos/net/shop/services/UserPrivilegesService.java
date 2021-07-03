package bertos.net.shop.services;

import bertos.net.shop.model.access.UserPrivileges;
import bertos.net.shop.repository.UserPrivilegesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

@Service
public class UserPrivilegesService extends
        AbstractCRUDServiceImpl<UserPrivileges, UserPrivilegesRepository> {

    public UserPrivilegesService(UserPrivilegesRepository repository) {
        super(repository, UserPrivileges.class);
    }


    public List<UserPrivileges> findByUser_Id(Long id) {
        return repository.findByUser_Id(id);
    }
}
