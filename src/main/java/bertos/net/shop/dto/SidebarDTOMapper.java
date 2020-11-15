package bertos.net.shop.dto;

import bertos.net.shop.model.Sidebar;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */
@Component
public class SidebarDTOMapper extends AbstractMapper<SidebarDTO, Sidebar> {

    protected SidebarDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, SidebarDTO.class, Sidebar.class);
    }
}
