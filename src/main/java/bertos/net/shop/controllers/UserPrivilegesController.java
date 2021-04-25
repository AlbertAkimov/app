package bertos.net.shop.controllers;

import bertos.net.shop.dto.UserPrivilegesDTO;
import bertos.net.shop.dto.mapper.UserPrivilegesMapper;
import bertos.net.shop.model.access.User;
import bertos.net.shop.model.access.UserPrivileges;
import bertos.net.shop.services.UserPrivilegesServiceImpl;
import org.springframework.http.MediaType;
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

    protected UserPrivilegesController(UserPrivilegesServiceImpl service, UserPrivilegesMapper mapper) {
        super(service, mapper, UserPrivileges.class);
    }

    @GetMapping("/user/{userId}")
    //@PreAuthorize("hasAuthority('READ:USERPRIVILEGES')")
    public List<UserPrivilegesDTO> findByUser(@PathVariable Long userId) {
        List<UserPrivileges> userPrivileges = service.findByUser_Id(userId);
        List<UserPrivilegesDTO> userPrivilegesDTO = new ArrayList<>();

        userPrivileges.forEach(x -> userPrivilegesDTO.add(mapper.toDTO(x)));
        return userPrivilegesDTO;
    }

    @PostMapping("/all")
    //@PreAuthorize("hasAuthority('WRITE:USERPRIVILEGER')")
    @Override
    public void saveAll(@RequestBody List<UserPrivileges> entities) {

/*        User user = entities.get(0).getUser();
        List<UserPrivileges> userPrivileges = service.findByUser_Id(user.getId());

        List<UserPrivileges> delete = new ArrayList<>();
        List<UserPrivileges> save = new ArrayList<>();

        for(UserPrivileges i: userPrivileges) {

            for(UserPrivileges j : entities) {

                if(i.getPermission().getPermission().equals(j.getPermission().getPermission())
                && i.getPermission().getId().equals(j.getPermission().getId()))
                    save.add(i);
                else if(i.getPermission().getPermission().equals(j.getPermission().getPermission())
                && j.getPermission().getId() == 0)
                    save.add(i);
                else
                    delete.add(i);
            }
        }*/

        service.saveAll(entities);
        //service.deleteAll(delete);
    }
}
