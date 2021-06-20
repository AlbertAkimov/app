package bertos.net.shop.services.chat;

import bertos.net.shop.model.chat.ChatMessage;
import bertos.net.shop.repository.chat.ChatMessageRepository;
import bertos.net.shop.services.AbstractCRUDServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 19.06.2021
 * @Description:
 */

@Service
public class ChatMessageService extends AbstractCRUDServiceImpl<ChatMessage, ChatMessageRepository> {

    public ChatMessageService(ChatMessageRepository repository) {
        super(repository, ChatMessage.class);
    }
}
