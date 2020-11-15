package bertos.net.shop.dto;

import bertos.net.shop.model.Product;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */
public class SidebarDTO extends AbstractDataTransferObject {

    private Long parentId;
    private String sidebarId;
    private String value;
    private String icon;
    private Boolean isGroup;
    private List<SidebarDTO> data;
}
