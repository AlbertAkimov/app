package bertos.net.shop.repository;

import bertos.net.shop.model.Product;
import org.springframework.stereotype.Repository;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
@Repository
public interface ProductRepository extends CRUDRepository<Product> {
}
