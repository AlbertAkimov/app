package bertos.net.shop.services.chat;

/**
 * @Authot: Albert Akimov
 * @Date: 20.06.2021
 * @Description:
 */

public interface ChatRoomService {

    Long findBySenderIdAndRecipientId(Long senderId, Long recipientId);
}
