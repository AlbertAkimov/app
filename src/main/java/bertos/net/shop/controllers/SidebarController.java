package bertos.net.shop.controllers;

import bertos.net.shop.dto.SidebarDTO;
import bertos.net.shop.dto.SidebarDTOMapper;
import bertos.net.shop.model.Sidebar;
import bertos.net.shop.services.SidebarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */

@RestController
@RequestMapping("/sidebar")
public class SidebarController extends AbstractRestControllerCRUD<Sidebar, SidebarDTO, SidebarService, SidebarDTOMapper> {

    protected SidebarController(SidebarService service, SidebarDTOMapper mapper) {
        super(service, Sidebar.class, mapper);
    }
}
