package bertos.net.shop.services;

import bertos.net.shop.model.Order;
import bertos.net.shop.repository.OrderRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 05.01.2022
 * @Description:
 */

@Service
public class OrderService extends AbstractCRUDServiceImpl<Order, OrderRepository> {

    public OrderService(OrderRepository repository) {
        super(repository, Order.class);
    }
}
