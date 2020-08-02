package bertos.net.shop.dto;

import bertos.net.shop.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */
@Component
public class ProductDTOMapper extends AbstractMapper<ProductDTO, Product> {

    protected ProductDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, ProductDTO.class, Product.class);
    }
}
