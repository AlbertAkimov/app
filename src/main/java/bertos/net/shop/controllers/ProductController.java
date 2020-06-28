package bertos.net.shop.controllers;

import bertos.net.shop.model.Product;
import bertos.net.shop.services.impl.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Authot: Albert Akimov
 * @Date: 31.05.2020
 * @Description:
 */

@RestController
@RequestMapping("/products")
public class ProductController extends AbstractRestControllerCRUD<Product, ProductService> {

    protected ProductController(ProductService service) {
        super(service, Product.class);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        Page<Product> productList = service.getAll(pageable);

        List<Product> result = productList.stream()
                .sorted(Comparator.comparingLong(Product::getParentId))
                .filter(Product::isGroup).collect(Collectors.toList());

        return new PageImpl<>(result);
    }
}
