package bertos.net.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Authot: Albert Akimov
 * @Date: 08.08.2020
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class TypePriceDTO extends AbstractDataTransferObject {

    private String name;
}
