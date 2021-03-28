package bertos.net.shop.dto;

import bertos.net.shop.model.access.RelationBridge;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RelationBridgeMapper extends AbstractMapper<RelationBridgeDTO, RelationBridge> {

    protected RelationBridgeMapper(ModelMapper modelMapper) {
        super(modelMapper, RelationBridgeDTO.class, RelationBridge.class);
    }
}
