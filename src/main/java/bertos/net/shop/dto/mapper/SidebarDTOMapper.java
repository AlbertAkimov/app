package bertos.net.shop.dto.mapper;

import bertos.net.shop.dto.SidebarDTO;
import bertos.net.shop.dto.mapper.AbstractMapper;
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
