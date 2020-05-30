package bertos.net.shop;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.services.CRUDService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.MappedSuperclass;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */

@Slf4j
public abstract class AbstractTestCRUD<E extends AbstractEntity, S extends CRUDService<E>>  {

    public final S service;
    public final E entity;

    @Autowired
    @SuppressWarnings("all")
    public AbstractTestCRUD(S service, E entity) {
        this.service = service;
        this.entity = entity;
    }

    private E save() {
        return service.save(entity);
    }

    private void delete() {
        service.delete(entity.getId());
    }

    private List<E> getAll() {
        return service.getAll();
    }

    private E getById() {
        return service.getById(entity.getId());
    }

    public void runTest() {

        log.info("running test's for entity: " + entity.getClass().getSimpleName());
        log.info("run task save..");

        E result = save();

        log.info("check of result executing task save");
        // нужно проверить ссылки, возможно они будут одинаковые
        Assert.assertEquals(entity.getId(), result.getId());

        Assert.assertEquals(entity.getId(), getById().getId());

    }

}
