package bertos.net.shop.dto;

import bertos.net.shop.model.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SidebarDTO extends AbstractDataTransferObject {

    private Long parentId;
    private String sidebarId;
    private String value;
    private String icon;
    private Boolean isGroup;
    private List<SidebarDTO> data;
}
