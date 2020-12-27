package bertos.net.shop.services;

import bertos.net.shop.model.Barcode;
import bertos.net.shop.repository.BarcodeRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 27.12.2020
 * @Description:
 */
@Service
public class BarcodeService extends AbstractCRUDServiceImpl<Barcode, BarcodeRepository> {

    public BarcodeService(BarcodeRepository repository) {
        super(repository, Barcode.class);
    }
}
