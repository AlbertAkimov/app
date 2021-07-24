package bertos.net.shop.repository.chat;

import bertos.net.shop.model.chat.ChatRoom;
import bertos.net.shop.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Authot: Albert Akimov
 * @Date: 20.06.2021
 * @Description:
 */

@Repository
public interface ChatRoomRepository extends CRUDRepository<ChatRoom> {

    ChatRoom findBySenderIdAndRecipientId(Long senderId, Long recipientId);
}
