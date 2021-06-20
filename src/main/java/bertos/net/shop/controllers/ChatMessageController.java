package bertos.net.shop.controllers;

import bertos.net.shop.dto.chat.ChatMessageDTO;
import bertos.net.shop.dto.mapper.chat.ChatMessageDTOMapper;
import bertos.net.shop.model.chat.ChatMessage;
import bertos.net.shop.model.chat.ChatNotification;
import bertos.net.shop.services.chat.ChatMessageService;
import bertos.net.shop.services.chat.ChatRoomServiceImp;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    protected final ChatRoomServiceImp chatRoomService;

    protected ChatMessageController(ChatMessageService service,
                                    ChatMessageDTOMapper mapper,
                                    SimpMessagingTemplate messagingTemplate,
                                    ChatRoomServiceImp chatRoomService) {

        super(service, mapper, ChatMessage.class);
        this.messagingTemplate = messagingTemplate;
        this.chatRoomService = chatRoomService;

    }

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {

        Long chatId = chatRoomService.findBySenderIdAndRecipientId(
                chatMessage.getSenderId(), chatMessage.getRecipientId());

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
}
