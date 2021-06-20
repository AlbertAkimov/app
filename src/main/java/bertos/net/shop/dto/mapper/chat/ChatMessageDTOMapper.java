package bertos.net.shop.dto.mapper.chat;

import bertos.net.shop.dto.chat.ChatMessageDTO;
import bertos.net.shop.dto.mapper.AbstractMapper;
import bertos.net.shop.model.chat.ChatMessage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 20.06.2021
 * @Description:
 */
@Component
public class ChatMessageDTOMapper extends AbstractMapper<ChatMessageDTO, ChatMessage> {

    protected ChatMessageDTOMapper(ModelMapper modelMapper) {
        super(modelMapper, ChatMessageDTO.class, ChatMessage.class);
    }
}
