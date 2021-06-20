package bertos.net.shop.model.chat;

import bertos.net.shop.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @Authot: Albert Akimov
 * @Date: 20.06.2021
 * @Description:
 */

@Data
@Entity
@Table(name = "chat_room")
public class ChatRoom extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "recipient_id")
    private Long recipientId;

}
