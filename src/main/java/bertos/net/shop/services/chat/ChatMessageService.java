package bertos.net.shop.services.chat;

import bertos.net.shop.exception.ResourceNotFoundException;
import bertos.net.shop.model.chat.ChatMessage;
import bertos.net.shop.model.chat.MessageStatus;
import bertos.net.shop.repository.chat.ChatMessageRepository;
import bertos.net.shop.services.AbstractCRUDServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 19.06.2021
 * @Description:
 */

@Service
public class ChatMessageService
        extends AbstractCRUDServiceImpl<ChatMessage, ChatMessageRepository> {

    public final ChatRoomService chatRoomService;

    @Resource
    protected EntityManager entityManager;

    public ChatMessageService(ChatMessageRepository repository, ChatRoomService chatRoomService) {
        super(repository, ChatMessage.class);
        this.chatRoomService = chatRoomService;
    }

    public Long countNewMessage(Long senderId, Long recipientId) {
        return repository.countBySenderIdAndRecipientIdAndMessageStatus(senderId, recipientId, MessageStatus.RECEIVED);
    }

    public List<ChatMessage> findChatMessage(Long senderId, Long recipientId) {

        Long chatId = chatRoomService.getChatId(senderId, recipientId, false);

        List<ChatMessage> messages = repository.findByChatId(chatId);

        if(messages == null)
            messages = new ArrayList<>();

        if(messages.size() > 0)
            updateStatuses(senderId, recipientId, MessageStatus.RECEIVED);

        return messages;
    }

    public ChatMessage findById(Long id) {

        return repository
                .findById(id)
                .map(chatMessage -> {
                    chatMessage.setMessageStatus(MessageStatus.DELIVERED);
                    return repository.save(chatMessage);
                })
                .orElseThrow(() ->
                        new ResourceNotFoundException("can't find message (" + id + ")"));

    }

    public void updateStatuses(Long senderId, Long recipientId, MessageStatus status) {

        // todo Возможно можно сделать по другому.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ChatMessage> cq  = cb.createQuery(ChatMessage.class);

        Root<ChatMessage> chatMessageRoot = cq.from(ChatMessage.class);
        Predicate senderIdPredicate = cb.equal(chatMessageRoot.get("senderId"), senderId);
        Predicate recipientIdPredicate = cb.equal(chatMessageRoot.get("recipientId"), recipientId);

        cq.where(senderIdPredicate, recipientIdPredicate);

        TypedQuery<ChatMessage> query = entityManager.createQuery(cq);

        List<ChatMessage> result = query.getResultList();

        result.forEach(x -> x.setMessageStatus(status));

        repository.saveAll(result);

    }
}
