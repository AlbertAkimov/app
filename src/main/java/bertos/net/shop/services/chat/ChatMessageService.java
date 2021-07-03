package bertos.net.shop.services.chat;

import bertos.net.shop.model.chat.ChatMessage;
import bertos.net.shop.model.chat.MessageStatus;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 29.06.2021
 * @Description:
 */

public interface ChatMessageService {

    List<ChatMessage> findByChatId(Long chatId);

    Long countBySenderIdAndRecipientIdAndMessageStatus(Long senderId, Long recipientId);
}
