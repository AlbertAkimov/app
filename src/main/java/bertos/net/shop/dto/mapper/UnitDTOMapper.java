package bertos.net.shop.dto.mapper;

import bertos.net.shop.dto.UnitDTO;
import bertos.net.shop.model.Unit;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

@Component
public class UnitDTOMapper extends AbstractMapper<UnitDTO, Unit> {

    protected UnitDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, UnitDTO.class, Unit.class);
    }
}
