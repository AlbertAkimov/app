package bertos.net.shop.repository.chat;

import bertos.net.shop.model.chat.ChatMessage;
import bertos.net.shop.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

/**
 * @Authot: Albert Akimov
 * @Date: 19.06.2021
 * @Description:
 */

@Repository
public interface ChatMessageRepository extends CRUDRepository<ChatMessage> {

}
