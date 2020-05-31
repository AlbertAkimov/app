package bertos.net.shop.services;

import bertos.net.shop.model.AbstractEntity;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
public interface CRUDService<E extends AbstractEntity> {

    E getById(Long id);
    E save(E entity);
    void delete(Long id);
    List<E> getAll();
    E findByGuid(String guid);
}
