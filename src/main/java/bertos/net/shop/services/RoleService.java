package bertos.net.shop.services;

import bertos.net.shop.model.access.Role;
import bertos.net.shop.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

@Service
public class RoleService extends AbstractCRUDServiceImpl<Role, RoleRepository> {

    public RoleService(RoleRepository repository) {
        super(repository, Role.class);
    }
}
