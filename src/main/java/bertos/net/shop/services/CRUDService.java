package bertos.net.shop.services;

import bertos.net.shop.model.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    Page<E> getAll(Pageable pageable);
    E findByGuid(String guid);
    void deleteByGuid(String guid);
    void saveAll(List<E> entities);
}
