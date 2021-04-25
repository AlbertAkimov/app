package bertos.net.shop.controllers;

import bertos.net.shop.dto.RoleDTO;
import bertos.net.shop.dto.mapper.RoleDTOMapper;
import bertos.net.shop.model.access.Role;
import bertos.net.shop.services.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authot: Albert Akimov
 * @Date: 24.04.2021
 * @Description:
 */

@RestController
@RequestMapping("/roles")
public class RoleController extends
        AbstractRestControllerCRUD<Role, RoleDTO, RoleService, RoleDTOMapper> {

    protected RoleController(RoleService service, RoleDTOMapper mapper) {
        super(service, mapper, Role.class);
    }
}
