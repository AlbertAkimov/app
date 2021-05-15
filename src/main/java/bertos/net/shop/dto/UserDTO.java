package bertos.net.shop.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */

@Data
@ToString
public class UserDTO extends AbstractDataTransferObject {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
