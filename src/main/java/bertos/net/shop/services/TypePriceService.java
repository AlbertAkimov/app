package bertos.net.shop.services;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.model.TypePrice;
import bertos.net.shop.repository.TypePriceRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 13.09.2020
 * @Description:
 */

@Service
public class TypePriceService extends AbstractCRUDServiceImpl<TypePrice, TypePriceRepository> {

    public TypePriceService(TypePriceRepository repository) {
        super(repository, TypePrice.class);
    }
}
