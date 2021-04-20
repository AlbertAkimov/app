package bertos.net.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class UserPrivilegesDTO extends AbstractDataTransferObject {

    private RoleDTO role;
    private PermissionDTO permission;
}
