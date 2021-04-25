package bertos.net.shop.dto.mapper;

import bertos.net.shop.dto.RoleDTO;
import bertos.net.shop.dto.mapper.AbstractMapper;
import bertos.net.shop.model.access.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 24.04.2021
 * @Description:
 */

@Component
public class RoleDTOMapper extends AbstractMapper<RoleDTO, Role> {

    protected RoleDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, RoleDTO.class, Role.class);
    }
}
