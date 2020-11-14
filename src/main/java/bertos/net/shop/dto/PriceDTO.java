package bertos.net.shop.dto;

import bertos.net.shop.model.TypePrice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class PriceDTO extends AbstractDataTransferObject {

    private Double price;
    private TypePrice typePrice;
}
