package bertos.net.shop.dto;

import bertos.net.shop.model.TypeProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class ProductDTO extends AbstractDataTransferObject {

    private Long parentId;
    private boolean isGroup;
    private String name;
    private TypeProduct typeProduct;
    private List<ProductDTO> data;
    private List<PriceDTO> prices;

}
