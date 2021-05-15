package bertos.net.shop.models;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.services.CRUDService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.OptionalLong;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */

@Slf4j
public abstract class AbstractTestCRUD<E extends AbstractEntity, S extends CRUDService<E>> {

    @Autowired
    @SuppressWarnings("all")
    protected S service;

    protected E entity;

    private boolean isDelete;

    public void init(E entity, boolean isDelete) {

        Assert.assertNotNull(entity);

        this.entity = entity;
        this.isDelete = isDelete;
    }

    private E save() {
        log.info("RUN test SAVE");
        return service.save(entity);
    }

    private void delete() {
        log.info("RUN test DELETE");
        service.delete(entity.getId());
    }

    private E findByGuid() {
        log.info("RUN test FIND_BY_GUID");
        return service.findByGuid(entity.getGuid());
    }

    private E getById() {
        log.info("RUN test FIND_BY_ID");
        return service.getById(entity.getId());
    }

    public void run() {

        Assert.assertNotNull(entity);

        log.info("running test's for entity: " + entity.getClass().getSimpleName());

        E result = save();
        entity.setId(result.getId());

        Assert.assertEquals(entity.getGuid(), findByGuid().getGuid());
        Assert.assertEquals(entity.getId(), getById().getId());

        if(isDelete) {
            delete();
            Assert.assertNull(getById());
        }

    }

}
