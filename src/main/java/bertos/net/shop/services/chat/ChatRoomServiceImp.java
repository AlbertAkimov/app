package bertos.net.shop.services.chat;

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

@Service
@Slf4j
public class ChatRoomServiceImp
        extends AbstractCRUDServiceImpl<ChatRoom, ChatRoomRepository>
        implements ChatRoomService {

    protected final ChatRoomRepository chatRoomRepository;

    public ChatRoomServiceImp(ChatRoomRepository repository, ChatRoomRepository chatRoomRepository) {
        super(repository, ChatRoom.class);
        this.chatRoomRepository = chatRoomRepository;
    }


    @Override
    public Long findBySenderIdAndRecipientId(Long senderId, Long recipientId) {
        return repository.findBySenderIdAndRecipientId(senderId, recipientId);
    }
}
