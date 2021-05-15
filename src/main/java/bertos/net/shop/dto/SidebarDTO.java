package bertos.net.shop.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */

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
