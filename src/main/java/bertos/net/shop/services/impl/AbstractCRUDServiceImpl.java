package bertos.net.shop.services.impl;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.repository.CRUD;
import bertos.net.shop.services.CRUDService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
@Slf4j
public abstract class AbstractCRUDServiceImpl<E extends AbstractEntity, R extends CRUD<E>> implements CRUDService<E> {

    protected final R repository;

    @Autowired
    public AbstractCRUDServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(E entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }
}
