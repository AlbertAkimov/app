package bertos.net.shop.services;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.model.Price;
import bertos.net.shop.repository.PriceRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */
@Service
public class PriceService extends AbstractCRUDServiceImpl<Price, PriceRepository> {

    public PriceService(PriceRepository repository) {
        super(repository, Price.class);
    }
}
