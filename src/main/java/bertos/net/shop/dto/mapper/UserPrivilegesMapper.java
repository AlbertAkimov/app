package bertos.net.shop.dto.mapper;

import bertos.net.shop.dto.UserPrivilegesDTO;
import bertos.net.shop.dto.mapper.AbstractMapper;
import bertos.net.shop.model.access.UserPrivileges;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */

@Component
public class UserPrivilegesMapper extends AbstractMapper<UserPrivilegesDTO, UserPrivileges> {

    protected UserPrivilegesMapper(ModelMapper modelMapper) {
        super(modelMapper, UserPrivilegesDTO.class, UserPrivileges.class);
    }
}
