package bertos.net.shop.dto;

import bertos.net.shop.model.TypePrice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 13.09.2020
 * @Description:
 */
@Component
public class TypePriceDTOMapper extends AbstractMapper<TypePriceDTO, TypePrice> {

    protected TypePriceDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, TypePriceDTO.class, TypePrice.class);
    }
}
