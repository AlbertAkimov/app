package bertos.net.shop.controllers;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.services.CRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * @Authot: Albert Akimov
 * @Date: 06.06.2020
 * @Description:
 */
public abstract class AbstractRestControllerCRUD<E extends AbstractEntity, S extends CRUDService<E>> {

    protected final S service;
    protected final Class<? extends AbstractEntity> clazz;

    protected AbstractRestControllerCRUD(S service, Class<? extends AbstractEntity> clazz) {
        this.service = service;
        this.clazz = clazz;
    }

    @GetMapping
    public Page<E> getAll(@PageableDefault Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("{id}")
    public E getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public E save(@RequestBody E entity) {
        return service.save(entity);
    }

    @PutMapping("{id}")
    public E update(@PathVariable("id") E object, @RequestBody E entity) {
        BeanUtils.copyProperties(entity, object, "id", "guid");

        return service.save(object);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") E entity) {
        //service.delete(entity.getId());
    }
}
