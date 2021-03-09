package bertos.net.shop.controllers;

import bertos.net.shop.dto.AbstractDataTransferObject;
import bertos.net.shop.dto.AbstractMapper;
import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.services.CRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 06.06.2020
 * @Description:
 */
@RestController
@SuppressWarnings("all")
public abstract class AbstractRestControllerCRUD<
        E extends AbstractEntity,
        D extends AbstractDataTransferObject,
        S extends CRUDService<E>,
        M extends AbstractMapper<D, E>> {

    protected final S service;
    protected final M mapper;
    public Class<E> classEntity;

    @Autowired
    protected AbstractRestControllerCRUD(S service, M mapper, Class<E> classEntity) {
        this.service = service;
        this.mapper = mapper;
        this.classEntity = classEntity;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ:' + #root.this.getClassName())")
    public List<D> getAll() {
        List<E> result = service.getAll();
        List<D> resultDTO = new ArrayList<>();

        result.forEach(x -> resultDTO.add(mapper.toDTO(x)));

        return resultDTO;
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('READ:' + #root.this.getClassName())")
    public D getById(@PathVariable("id") Long id) {
        return mapper.toDTO(service.getById(id));
    }

/*    @GetMapping("{name}")
    @PreAuthorize("hasAuthority('READ:' + #root.this.getClassName())")
    public D findByName(@PathVariable String name) {
        return null;
    }*/

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE:' + #root.this.getClassName())")
    public E save(@RequestBody E entity) {
        return service.save(entity);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('WRITE:' + #root.this.getClassName())")
    public E update(@PathVariable("id") E object, @RequestBody E entity) {
        BeanUtils.copyProperties(entity, object, "id", "guid");

        return service.save(object);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('DELETE:' + #root.this.getClassName())")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    public String getClassName() {
        return classEntity.getSimpleName().toUpperCase();
    }
}
