package bertos.net.shop.controllers;

import bertos.net.shop.dto.ProductDTO;
import bertos.net.shop.dto.ProductDTOMapper;
import bertos.net.shop.model.Product;
import bertos.net.shop.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
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
        super(service, Product.class, mapper);
    }

    @Override
    public Page<ProductDTO> getAll(@PageableDefault(value = 1000000) Pageable pageable) {

        List<ProductDTO> resultDTO = new ArrayList<>();
        Page<Product> productList = service.getAll(pageable);

        List<Product> result = productList.stream()
                .sorted(Comparator.comparingLong(Product::getParentId))
                .filter(Product::getIsGroup).collect(Collectors.toList());

        result.forEach(elem -> resultDTO.add(mapper.toDTO(elem)));

        return new PageImpl<>(resultDTO);
    }
}
