package bertos.net.shop.controllers;

import bertos.net.shop.dto.ProductDTO;
import bertos.net.shop.dto.ProductDTOMapper;
import bertos.net.shop.model.Product;
import bertos.net.shop.services.ProductService;
import bertos.net.shop.utils.BarcodeUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
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
@RequestMapping(value = "/products")
public class ProductController extends
        AbstractRestControllerCRUD<Product, ProductDTO, ProductService, ProductDTOMapper> {

    protected ProductController(ProductService service, ProductDTOMapper mapper) {
        super(service, mapper, Product.class);
    }

    @Override
    public List<ProductDTO> getAll() {

        List<ProductDTO> resultDTO = new ArrayList<>();
        List<Product> productList = service.getAll();

        List<Product> result = productList.parallelStream()
                .sorted(Comparator.comparingLong(Product::getParentId))
                .filter(Product::getIsGroup)
                .filter(x -> x.getLevelGroup() <= 1).collect(Collectors.toList());

        result.forEach(elem -> resultDTO.add(mapper.toDTO(elem)));

        return resultDTO;
    }

    @Override
    @GetMapping("{id}")
    public ProductDTO getById(@PathVariable("id") Long id) {

        Product product = service.getById(id);

        if(product.getBarcode() != null) {
            BufferedImage image = BarcodeUtils.createEAN13(product.getBarcode().getCode());
            String barcodeBase64 = BarcodeUtils.encodeBarcodeToBase64(image);
            product.getBarcode().setImageBarcode(barcodeBase64);
        }

        return mapper.toDTO(product);
    }
}
