package bertos.net.shop.services;

import bertos.net.shop.model.Product;
import bertos.net.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
@Service
public class ProductService extends AbstractCRUDServiceImpl<Product, ProductRepository> {

    public ProductService(ProductRepository repository) {
        super(repository, Product.class);
    }
}
