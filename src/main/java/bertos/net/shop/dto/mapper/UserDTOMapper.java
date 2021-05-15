package bertos.net.shop.dto.mapper;

import bertos.net.shop.dto.UserDTO;
import bertos.net.shop.dto.mapper.AbstractMapper;
import bertos.net.shop.model.access.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */

@Component
public class UserDTOMapper extends AbstractMapper<UserDTO, User> {

    protected UserDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, UserDTO.class, User.class);
    }
}
