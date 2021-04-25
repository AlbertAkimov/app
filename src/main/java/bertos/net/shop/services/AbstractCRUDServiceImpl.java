package bertos.net.shop.services;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.repository.CRUDRepository;
import bertos.net.shop.services.CRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
    public void deleteByGuid(String guid) {
        repository.deleteByGuid(guid);
        log.info("entity: " + clazz + " successfully deleted by guid: " + guid);
    }

    @Override
    public List<E> getAll() {

        List<E> listEntity = repository.findAll();

        if(!listEntity.isEmpty())
            log.info("list entities: " + clazz + " successfully load");

        return listEntity;
    }

    @Override
    public Page<E> getAll(Pageable pageable) {

        Page<E> pageEntity = repository.findAll(pageable);

        if(!pageEntity.isEmpty())
            log.info("page entities: " + clazz + " successfully load");

        return pageEntity;
    }

    @Override
    public void saveAll(List<E> entities) {
        repository.saveAll(entities);
        log.info("Successfully save list of entities: " + clazz);
    }

    @Override
    public void deleteAll(List<E> entities) {
        repository.deleteAll(entities);
        log.info("Successfully delete list of entities: " + clazz);
    }
}
