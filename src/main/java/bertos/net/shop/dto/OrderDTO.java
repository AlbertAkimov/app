package bertos.net.shop.dto;

import bertos.net.shop.model.Card;
import bertos.net.shop.model.Partner;
import bertos.net.shop.model.ProductsOfOrder;
import lombok.Data;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 05.01.2022
 * @Description:
 */

@Data
public class OrderDTO extends AbstractDataTransferObject {

    private Double totalSum;
    private Card card;
    private Partner owner;
    private List<ProductsOfOrder> products;
}
