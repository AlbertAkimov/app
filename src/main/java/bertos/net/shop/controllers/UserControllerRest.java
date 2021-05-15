package bertos.net.shop.controllers;

import bertos.net.shop.dto.UserDTO;
import bertos.net.shop.dto.mapper.UserDTOMapper;
import bertos.net.shop.model.access.User;
import bertos.net.shop.services.UserServiceImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

@RestController
@RequestMapping("/users")
public class UserControllerRest extends
        AbstractRestControllerCRUD<User, UserDTO, UserServiceImp, UserDTOMapper> {

    protected UserControllerRest(UserServiceImp service, UserDTOMapper mapper) {
        super(service, mapper, User.class);
    }
}
