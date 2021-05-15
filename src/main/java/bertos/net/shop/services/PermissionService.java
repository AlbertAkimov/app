package bertos.net.shop.services;

import bertos.net.shop.model.access.Permission;
import bertos.net.shop.repository.PermissionRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 25.04.2021
 * @Description:
 */

@Service
public class PermissionService extends AbstractCRUDServiceImpl<Permission, PermissionRepository> {

    public PermissionService(PermissionRepository repository) {
        super(repository, Permission.class);
    }
}
