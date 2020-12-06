package bertos.net.shop.controllers;

import bertos.net.shop.dto.SidebarDTO;
import bertos.net.shop.dto.SidebarDTOMapper;
import bertos.net.shop.model.Product;
import bertos.net.shop.model.Sidebar;
import bertos.net.shop.services.SidebarService;
import javafx.geometry.Side;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */

@RestController
@RequestMapping("/sidebar")
public class SidebarController extends AbstractRestControllerCRUD<Sidebar, SidebarDTO, SidebarService, SidebarDTOMapper> {

    protected SidebarController(SidebarService service, SidebarDTOMapper mapper) {
        super(service, mapper);
    }

    @Override
    public List<SidebarDTO> getAll() {

        List<SidebarDTO> resultDTO = new ArrayList<>();
        List<Sidebar> sidebar = service.getAll();

        List<Sidebar> result = sidebar.stream()
                .sorted(Comparator.comparingLong(Sidebar::getParentId))
                .filter(Sidebar::getIsGroup).collect(Collectors.toList());

        result.forEach(elem -> resultDTO.add(mapper.toDTO(elem)));

        return resultDTO;
    }
}
