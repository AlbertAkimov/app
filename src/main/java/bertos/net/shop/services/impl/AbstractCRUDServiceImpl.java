package bertos.net.shop.services.impl;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.repository.CRUDRepository;
import bertos.net.shop.services.CRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
@Slf4j
public abstract class AbstractCRUDServiceImpl<E extends AbstractEntity, R extends CRUDRepository<E>> implements CRUDService<E> {

    protected final R repository;
    private final String clazz;

    @Autowired
    @SuppressWarnings("all")
    public AbstractCRUDServiceImpl(R repository, Class<? extends AbstractEntity> clazz) {
        this.repository = repository;
        this.clazz = clazz.getName();
    }

    @Override
    public E getById(Long id) {

        E entity = repository.findById(id).orElse(null);

        if(entity != null)
            log.info("entity: " + clazz + " successfully found by id: " + id);

        return entity;
    }

    @Override
    public E findByGuid(String guid) {

        E entity = repository.findByGuid(guid);

        if(entity != null)
            log.info("entity: " + clazz + " successfully found by guid: " + guid);

        return entity;
    }

    @Override
    public E save(E entity) {
        E result = repository.save(entity);
        log.info("entity: " + clazz + " successfully saved");
        return result;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
        log.info("entity: " + clazz + " successfully deleted by id: " + id);
    }

    @Override
    public List<E> getAll() {

        List<E> listEntity = repository.findAll();

        if(!listEntity.isEmpty())
            log.info("list entities: " + clazz + " successfully load");

        return listEntity;
    }
}
