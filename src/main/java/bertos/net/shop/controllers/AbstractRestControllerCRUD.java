package bertos.net.shop.controllers;

import bertos.net.shop.dto.AbstractDataTransferObject;
import bertos.net.shop.dto.AbstractMapper;
import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.services.CRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 06.06.2020
 * @Description:
 */
public abstract class AbstractRestControllerCRUD
        <E extends AbstractEntity, D extends AbstractDataTransferObject, S extends CRUDService<E>, M extends AbstractMapper<D, E>> {

    protected final S service;
    protected final M mapper;

    protected AbstractRestControllerCRUD(S service, M mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<D> getAll() {
        List<E> result = service.getAll();
        List<D> resultDTO = new ArrayList<>();

        result.forEach(x -> resultDTO.add(mapper.toDTO(x)));

        return resultDTO;
    }

    @GetMapping("{id}")
    public D getById(@PathVariable("id") Long id) {
        return mapper.toDTO(service.getById(id));
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
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
