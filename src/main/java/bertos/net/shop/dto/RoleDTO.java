package bertos.net.shop.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */

@Data
@ToString
public class RoleDTO extends AbstractDataTransferObject {

    private String name;
}
