package bertos.net.shop.services.chat;

import bertos.net.shop.model.Status;
import bertos.net.shop.model.chat.ChatRoom;
import bertos.net.shop.repository.chat.ChatRoomRepository;
import bertos.net.shop.services.AbstractCRUDServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 20.06.2021
 * @Description:
 */


@Slf4j
@Service
public class ChatRoomService
        extends AbstractCRUDServiceImpl<ChatRoom, ChatRoomRepository> {

    public ChatRoomService(ChatRoomRepository repository) {
        super(repository, ChatRoom.class);
    }

    public Long getChatId(Long senderId, Long recipientId, boolean createIfNotExist) {

        ChatRoom chatRoom = repository.findBySenderIdAndRecipientId(senderId, recipientId);
        Long chatId = 0L;

        if(chatRoom != null)
            chatId = chatRoom.getChatId();

        else if(createIfNotExist) {

            chatId = senderId + recipientId;

            ChatRoom senderRecipient = new ChatRoom();
            senderRecipient.setStatus(Status.ACTIVE);
            senderRecipient.setChatId(chatId);
            senderRecipient.setSenderId(senderId);
            senderRecipient.setRecipientId(recipientId);

            ChatRoom recipientSender = new ChatRoom();
            recipientSender.setStatus(Status.ACTIVE);
            recipientSender.setChatId(chatId);
            recipientSender.setSenderId(senderId);
            recipientSender.setRecipientId(recipientId);
        }
        return chatId;
    }
}
