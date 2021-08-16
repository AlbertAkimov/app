package bertos.net.shop.dto.chat;

import bertos.net.shop.dto.AbstractDataTransferObject;
import lombok.Data;

/**
 * @Authot: Albert Akimov
 * @Date: 20.06.2021
 * @Description:
 */

@Data
public class ChatMessageDTO extends AbstractDataTransferObject {

    public String senderName;
    public String content;
}
