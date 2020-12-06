package bertos.net.shop.controllers;

import bertos.net.shop.dto.ProductDTO;
import bertos.net.shop.dto.ProductDTOMapper;
import bertos.net.shop.model.Product;
import bertos.net.shop.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Authot: Albert Akimov
 * @Date: 31.05.2020
 * @Description:
 */

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController extends
        AbstractRestControllerCRUD<Product, ProductDTO, ProductService, ProductDTOMapper> {

    protected ProductController(ProductService service, ProductDTOMapper mapper) {
        super(service, mapper);
    }

    @Override
    public List<ProductDTO> getAll() {

        List<ProductDTO> resultDTO = new ArrayList<>();
        List<Product> productList = service.getAll();

 /*       long start;
        long end;

        start = System.currentTimeMillis();*/

        List<Product> result = productList.parallelStream()
                .sorted(Comparator.comparingLong(Product::getParentId))
                .filter(Product::getIsGroup)
                .filter(x -> x.getLevelGroup() <= 1).collect(Collectors.toList());

        result.forEach(elem -> resultDTO.add(mapper.toDTO(elem)));

/*        end = System.currentTimeMillis();
        System.out.println(end - start + " ms");*/

        return resultDTO;
    }
}
