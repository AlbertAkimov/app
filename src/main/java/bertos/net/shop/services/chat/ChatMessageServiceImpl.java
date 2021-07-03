package bertos.net.shop.services.chat;

import bertos.net.shop.model.chat.ChatMessage;
import bertos.net.shop.model.chat.MessageStatus;
import bertos.net.shop.repository.chat.ChatMessageRepository;
import bertos.net.shop.services.AbstractCRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 19.06.2021
 * @Description:
 */

@Service
public class ChatMessageServiceImpl
        extends AbstractCRUDServiceImpl<ChatMessage, ChatMessageRepository>
        implements ChatMessageService{

    public ChatMessageServiceImpl(ChatMessageRepository repository) {
        super(repository, ChatMessage.class);
    }

    @Override
    public List<ChatMessage> findByChatId(Long chatId) {
        return repository.findByChatId(chatId);
    }

    @Override
    public Long countBySenderIdAndRecipientIdAndMessageStatus(Long senderId, Long recipientId) {
        return repository.countBySenderIdAndRecipientIdAndMessageStatus(senderId, recipientId, MessageStatus.RECEIVED);
    }
}
