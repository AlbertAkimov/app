package bertos.net.shop.controllers;

import bertos.net.shop.dto.RelationBridgeDTO;
import bertos.net.shop.dto.RelationBridgeMapper;
import bertos.net.shop.model.access.RelationBridge;
import bertos.net.shop.services.RelationBridgeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/privileges")
public class RelationBridgeController extends AbstractRestControllerCRUD<
        RelationBridge, RelationBridgeDTO, RelationBridgeService, RelationBridgeMapper> {

    protected RelationBridgeController(RelationBridgeService service, RelationBridgeMapper mapper) {
        super(service, mapper, RelationBridge.class);
    }
}
