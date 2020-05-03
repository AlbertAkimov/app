package bertos.net.shop.controllers;

import bertos.net.shop.model.AbstractEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 26.02.2020
 * @Description:
 */
public interface CRUDController<E extends AbstractEntity> {

    ResponseEntity<E> getById(Long id);

    ResponseEntity<E> save(E entity);

    ResponseEntity<E> update(E entity);

    ResponseEntity<E> delete(Long id);

    ResponseEntity<List<E>> getAll();

}
