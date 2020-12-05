package bertos.net.shop.services;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.model.Unit;
import bertos.net.shop.repository.UnitRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 06.12.2020
 * @Description:
 */
@Service
public class UnitService extends AbstractCRUDServiceImpl<Unit, UnitRepository>{

    public UnitService(UnitRepository repository) {
        super(repository, Unit.class);
    }
}
