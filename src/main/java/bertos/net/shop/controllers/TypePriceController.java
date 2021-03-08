package bertos.net.shop.controllers;

import bertos.net.shop.dto.TypePriceDTO;
import bertos.net.shop.dto.TypePriceDTOMapper;
import bertos.net.shop.model.TypePrice;
import bertos.net.shop.services.TypePriceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authot: Albert Akimov
 * @Date: 13.09.2020
 * @Description:
 */

@RestController
@RequestMapping("/typePrice")
public class TypePriceController extends AbstractRestControllerCRUD<TypePrice, TypePriceDTO, TypePriceService, TypePriceDTOMapper> {

    protected TypePriceController(TypePriceService service, TypePriceDTOMapper mapper) {
        super(service, mapper, TypePrice.class);
    }
}
