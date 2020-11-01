package bertos.net.shop.dto;

import bertos.net.shop.model.TypePrice;
import lombok.Data;
import lombok.ToString;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */
@Data
@ToString
public class PriceDTO extends AbstractDataTransferObject {

    private Double price;
    private TypePrice typePrice;
}
