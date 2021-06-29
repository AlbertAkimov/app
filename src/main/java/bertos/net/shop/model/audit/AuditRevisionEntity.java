package bertos.net.shop.model.audit;

import bertos.net.shop.listeners.AuditRevisionListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Authot: Albert Akimov
 * @Date: 27.06.2021
 * @Description:
 */

@Entity
@Table(name = "revision_info")
@RevisionEntity(AuditRevisionListener.class)
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AuditRevisionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @RevisionNumber
    private int id;

    @Column(name = "rev_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date timestamp;

    @Column(name = "user")
    private String user;
}
