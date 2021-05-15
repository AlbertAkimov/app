package bertos.net.shop.controllers;

import bertos.net.shop.dto.UserPrivilegesDTO;
import bertos.net.shop.dto.mapper.UserPrivilegesMapper;
import bertos.net.shop.model.access.Permission;
import bertos.net.shop.model.access.User;
import bertos.net.shop.model.access.UserPrivileges;
import bertos.net.shop.services.PermissionService;
import bertos.net.shop.services.UserPrivilegesServiceImpl;
import bertos.net.shop.services.UserServiceImp;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 29.04.2020
 * @Description:
 */

@RestController
@RequestMapping(value = "/privileges", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserPrivilegesController extends AbstractRestControllerCRUD<
        UserPrivileges, UserPrivilegesDTO, UserPrivilegesServiceImpl, UserPrivilegesMapper> {

    protected final PermissionService permissionService;
    protected final UserServiceImp userService;

    protected UserPrivilegesController(UserPrivilegesServiceImpl service, UserPrivilegesMapper mapper, PermissionService permissionService, UserServiceImp userService) {
        super(service, mapper, UserPrivileges.class);
        this.permissionService = permissionService;
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAuthority('READ:USERPRIVILEGES')")
    public List<UserPrivilegesDTO> findByUser(@PathVariable Long userId) {
        List<UserPrivileges> userPrivileges = service.findByUser_Id(userId);
        List<UserPrivilegesDTO> userPrivilegesDTO = new ArrayList<>();

        userPrivileges.forEach(x -> userPrivilegesDTO.add(mapper.toDTO(x)));
        return userPrivilegesDTO;
    }

    @PostMapping("/all")
    @PreAuthorize("hasAuthority('WRITE:USERPRIVILEGES')")
    @Override
    public void saveAll(@RequestBody List<UserPrivileges> userPrivileges) {

        Long userId = userPrivileges.get(0).getUser().getId();
        User user = userService.getById(userId);
        List<UserPrivileges> currentPrivileges = service.findByUser_Id(userId);

        service.deleteAll(currentPrivileges);

        List<Permission> permissions = permissionService.getAll();

        userPrivileges.forEach(x -> x.setUser(user));
        userPrivileges.forEach(x -> {
            if(permissions.contains(x.getPermission())) {
                x.setPermission(permissions.get(permissions.indexOf(x.getPermission())));
            }
        });

        if(userPrivileges.get(0).getPermission() != null)
            service.saveAll(userPrivileges);
    }
}
