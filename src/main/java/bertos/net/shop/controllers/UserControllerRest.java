package bertos.net.shop.controllers;

import bertos.net.shop.dto.UserDTO;
import bertos.net.shop.dto.UserDTOMapper;
import bertos.net.shop.model.access.RelationBridge;
import bertos.net.shop.model.access.User;
import bertos.net.shop.services.UserServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserControllerRest extends
        AbstractRestControllerCRUD<User, UserDTO, UserServiceImp, UserDTOMapper> {

    protected UserControllerRest(UserServiceImp service, UserDTOMapper mapper) {
        super(service, mapper, User.class);
    }
}
