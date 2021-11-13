package bertos.net.shop.model.chat;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.model.access.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Authot: Albert Akimov
 * @Date: 08.06.2021
 * @Description:
 */

@Data
@Entity
@Table(name = "chat_message")
public class ChatMessage extends AbstractEntity {

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "recipient_id")
    private Long recipientId;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Enumerated(EnumType.STRING)
    @Column(name = "message_status")
    private MessageStatus messageStatus;

}
