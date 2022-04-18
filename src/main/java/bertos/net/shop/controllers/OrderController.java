package bertos.net.shop.controllers;

import bertos.net.shop.dto.OrderDTO;
import bertos.net.shop.dto.mapper.OrderDTOMapper;
import bertos.net.shop.model.Order;
import bertos.net.shop.services.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authot: Albert Akimov
 * @Date: 05.01.2022
 * @Description:
 */

@RestController
@RequestMapping(value = "/orders")
public class OrderController
        extends AbstractRestControllerCRUD<Order, OrderDTO, OrderService, OrderDTOMapper> {

    protected OrderController(OrderService service, OrderDTOMapper mapper) {
        super(service, mapper, Order.class);
    }
}
