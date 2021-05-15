package bertos.net.shop.dto;

import bertos.net.shop.model.TypeProduct;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */

@Data
@ToString
public class ProductDTO extends AbstractDataTransferObject {

    private Long parentId;
    private Boolean isGroup;
    private String name;
    private Integer levelGroup;
    private TypeProduct typeProduct;
    private List<ProductDTO> data;
    private List<PriceDTO> prices;
    private UnitDTO unit;
    private BarcodeDTO barcode;

}
