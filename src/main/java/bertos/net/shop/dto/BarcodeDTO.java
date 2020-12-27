package bertos.net.shop.dto;

import bertos.net.shop.model.Status;
import bertos.net.shop.model.TypeBarcode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Authot: Albert Akimov
 * @Date: 27.12.2020
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BarcodeDTO extends AbstractDataTransferObject {

    private String barcode;
    private TypeBarcode typeBarcode;
    private Status status;
}
