package bertos.net.shop.dto;

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
