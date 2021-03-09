package bertos.net.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class RoleDTO extends AbstractDataTransferObject {

    private String name;
}
