package bertos.net.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class UserDTO extends AbstractDataTransferObject {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    //private List<RelationBridgeDTO> bridges;
}
