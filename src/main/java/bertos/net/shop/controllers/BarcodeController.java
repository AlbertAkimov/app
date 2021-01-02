package bertos.net.shop.controllers;

import bertos.net.shop.dto.BarcodeDTO;
import bertos.net.shop.dto.BarcodeDTOMapper;
import bertos.net.shop.model.Barcode;
import bertos.net.shop.services.BarcodeService;
import bertos.net.shop.utils.BarcodeUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;


/**
 * @Authot: Albert Akimov
 * @Date: 31.12.2020
 * @Description:
 */

@RestController
@RequestMapping(value = "/barcodes", produces = MediaType.APPLICATION_JSON_VALUE)
public class BarcodeController extends AbstractRestControllerCRUD<Barcode, BarcodeDTO, BarcodeService, BarcodeDTOMapper> {

    protected BarcodeController(BarcodeService service, BarcodeDTOMapper mapper) {
        super(service, mapper);
    }

    @Override
    @GetMapping("{id}")
    public BarcodeDTO getById(@PathVariable("id") Long id) {

        Barcode result = service.getById(id);

        BufferedImage image = BarcodeUtils.createEAN13(result.getCode());
        String barcodeBase64 = BarcodeUtils.encodeBarcodeToBase64(image);
        result.setImageBarcode(barcodeBase64);

        return mapper.toDTO(result);
    }
    
}
