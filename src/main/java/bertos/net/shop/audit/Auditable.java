package bertos.net.shop.audit;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Authot: Albert Akimov
 * @Date: 08.01.2021
 * @Description:
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable<E> {

    @CreatedBy
    @Column(name = "created_by")
    protected E createdBy;

    @CreatedDate
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date creationDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected E lastModifiedBy;

    @LastModifiedDate
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;

    //TODO Нужно подумать как не наследовать или отключать поля аудита там где оно не нужно.

}

