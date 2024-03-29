package bertos.net.shop.controllers.chat;

import bertos.net.shop.controllers.AbstractRestControllerCRUD;
import bertos.net.shop.dto.chat.ChatMessageDTO;
import bertos.net.shop.dto.mapper.chat.ChatMessageDTOMapper;
import bertos.net.shop.model.chat.ChatMessage;
import bertos.net.shop.model.chat.ChatNotification;
import bertos.net.shop.services.chat.ChatMessageService;
import bertos.net.shop.services.chat.ChatRoomService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 08.06.2021
 * @Description:
 */

@RestController
@RequestMapping(value = "/chat")
public class ChatMessageController extends AbstractRestControllerCRUD
        <ChatMessage, ChatMessageDTO, ChatMessageService, ChatMessageDTOMapper> {

    protected final SimpMessagingTemplate messagingTemplate;
    protected final ChatRoomService chatRoomService;

    protected ChatMessageController(ChatMessageService service,
                                    ChatMessageDTOMapper mapper,
                                    SimpMessagingTemplate messagingTemplate,
                                    ChatRoomService chatRoomService) {

        super(service, mapper, ChatMessage.class);
        this.messagingTemplate = messagingTemplate;
        this.chatRoomService = chatRoomService;

    }

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {

        Long chatId = chatRoomService.getChatId(
                chatMessage.getSenderId(), chatMessage.getRecipientId(), true);

        chatMessage.setChatId(chatId);
        ChatMessage saved = service.save(chatMessage);

        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId().toString(),"/queue/messages",
                new ChatNotification(
                        saved.getId(),
                        saved.getSenderId(),
                        saved.getSenderName()
                )
        );
    }

    @GetMapping("/messages/{senderId}/{recipientId}/count")
    @PreAuthorize("hasAuthority('READ:CHATMESSAGE')")
    public Long countNewMessage(@PathVariable Long senderId, @PathVariable Long recipientId) {
        return service.countNewMessage(senderId, recipientId);
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    @PreAuthorize("hasAuthority('READ:CHATMESSAGE')")
    public List<ChatMessage> findChatMessage(@PathVariable Long senderId, @PathVariable Long recipientId) {
        return service.findChatMessage(senderId, recipientId);
    }

    @GetMapping("/messages/{id}")
    @PreAuthorize("hasAuthority('READ:CHATMESSAGE')")
    public ChatMessage findChatMessage(@PathVariable Long id) {
        return service.findById(id);
    }
}
