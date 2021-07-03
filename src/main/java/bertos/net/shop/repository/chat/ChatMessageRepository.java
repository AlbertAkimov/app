package bertos.net.shop.repository.chat;

import bertos.net.shop.model.chat.ChatMessage;
import bertos.net.shop.model.chat.MessageStatus;
import bertos.net.shop.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 19.06.2021
 * @Description:
 */

@Repository
public interface ChatMessageRepository extends CRUDRepository<ChatMessage> {

    List<ChatMessage> findByChatId(Long chatId);

    Long countBySenderIdAndRecipientIdAndMessageStatus(Long senderId, Long recipientId, MessageStatus status);
}
