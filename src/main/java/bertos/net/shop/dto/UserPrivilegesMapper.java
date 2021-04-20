package bertos.net.shop.dto;

import bertos.net.shop.model.access.UserPrivileges;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserPrivilegesMapper extends AbstractMapper<UserPrivilegesDTO, UserPrivileges> {

    protected UserPrivilegesMapper(ModelMapper modelMapper) {
        super(modelMapper, UserPrivilegesDTO.class, UserPrivileges.class);
    }
}
