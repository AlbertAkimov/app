package bertos.net.shop.controllers;

import bertos.net.shop.dto.UserPrivilegesDTO;
import bertos.net.shop.dto.UserPrivilegesMapper;
import bertos.net.shop.model.access.UserPrivileges;
import bertos.net.shop.services.UserPrivilegesServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/privileges", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserPrivilegesController extends AbstractRestControllerCRUD<
        UserPrivileges, UserPrivilegesDTO, UserPrivilegesServiceImpl, UserPrivilegesMapper> {

    protected UserPrivilegesController(UserPrivilegesServiceImpl service, UserPrivilegesMapper mapper) {
        super(service, mapper, UserPrivileges.class);
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAuthority('ROLE_BASE')")
    public List<UserPrivilegesDTO> findByUser(@PathVariable Long userId) {
        List<UserPrivileges> userPrivileges = service.findByUser_Id(userId);
        List<UserPrivilegesDTO> userPrivilegesDTO = new ArrayList<>();

        userPrivileges.forEach(x -> userPrivilegesDTO.add(mapper.toDTO(x)));
        return userPrivilegesDTO;
    }
}
