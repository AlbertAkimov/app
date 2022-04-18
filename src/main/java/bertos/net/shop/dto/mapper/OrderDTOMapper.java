package bertos.net.shop.dto.mapper;

import bertos.net.shop.dto.OrderDTO;
import bertos.net.shop.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 05.01.2022
 * @Description:
 */

@Component
public class OrderDTOMapper extends AbstractMapper<OrderDTO, Order> {

    protected OrderDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, OrderDTO.class, Order.class);
    }
}
