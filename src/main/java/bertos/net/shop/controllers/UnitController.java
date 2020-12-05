package bertos.net.shop.controllers;

import bertos.net.shop.dto.UnitDTO;
import bertos.net.shop.dto.UnitDTOMapper;
import bertos.net.shop.model.Unit;
import bertos.net.shop.services.UnitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

@RestController
@RequestMapping("/units")
public class UnitController extends AbstractRestControllerCRUD<Unit, UnitDTO, UnitService, UnitDTOMapper> {

    protected UnitController(UnitService service, UnitDTOMapper mapper) {
        super(service, Unit.class, mapper);
    }
}
