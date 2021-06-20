package bertos.net.shop.model.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Authot: Albert Akimov
 * @Date: 19.06.2021
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {

    private Long id;
    private Long senderId;
    private String senderName;
}
