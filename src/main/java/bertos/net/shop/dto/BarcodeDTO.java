package bertos.net.shop.dto;

import bertos.net.shop.model.Status;
import bertos.net.shop.model.TypeBarcode;
import lombok.Data;
import lombok.ToString;

/**
 * @Authot: Albert Akimov
 * @Date: 27.12.2020
 * @Description:
 */

@Data
@ToString
public class BarcodeDTO extends AbstractDataTransferObject {

    private String code;
    private TypeBarcode typeBarcode;
    private Status status;
    private String imageBarcode;
}
