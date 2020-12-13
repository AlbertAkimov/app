package bertos.net.shop.dto;

import bertos.net.shop.model.Status;
import lombok.Data;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */
@Data
@ToString
@MappedSuperclass
public abstract class AbstractDataTransferObject implements Serializable {

    protected Long id;
    protected String guid; // todo don't use this field
    private Status status;

}
