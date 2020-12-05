package bertos.net.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class UnitDTO extends AbstractDataTransferObject {

    private String unitName;
}
