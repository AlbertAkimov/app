package bertos.net.shop.services;

import bertos.net.shop.model.access.RelationBridge;
import bertos.net.shop.repository.RelationBridgeRepository;
import org.springframework.stereotype.Service;

@Service
public class RelationBridgeService extends AbstractCRUDServiceImpl<RelationBridge, RelationBridgeRepository> {

    public RelationBridgeService(RelationBridgeRepository repository) {
        super(repository, RelationBridge.class);
    }
}
