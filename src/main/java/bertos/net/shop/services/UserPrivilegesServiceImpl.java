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
public class UserPrivilegesServiceImpl extends
        AbstractCRUDServiceImpl<UserPrivileges, UserPrivilegesRepository>
        implements UserPrivilegesService {

    public UserPrivilegesServiceImpl(UserPrivilegesRepository repository) {
        super(repository, UserPrivileges.class);
    }

    @Override
    public List<UserPrivileges> findByUser_Id(Long id) {
        return repository.findByUser_Id(id);
    }
}
