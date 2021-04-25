package bertos.net.shop.dto.mapper;

import bertos.net.shop.dto.BarcodeDTO;
import bertos.net.shop.dto.mapper.AbstractMapper;
import bertos.net.shop.model.Barcode;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 27.12.2020
 * @Description:
 */

@Component
public class BarcodeDTOMapper extends AbstractMapper<BarcodeDTO, Barcode> {

    protected BarcodeDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, BarcodeDTO.class, Barcode.class);
    }
}
