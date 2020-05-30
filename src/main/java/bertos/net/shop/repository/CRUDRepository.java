package bertos.net.shop.repository;

import bertos.net.shop.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Authot: Albert Akimov
 * @Date: 26.04.2020
 * @Description:
 */
public interface CRUDRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {
}
