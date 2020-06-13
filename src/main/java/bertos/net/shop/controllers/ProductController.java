package bertos.net.shop.controllers;

import bertos.net.shop.ProductsTreeDTO;
import bertos.net.shop.model.Product;
import bertos.net.shop.services.impl.ProductService;
import bertos.net.shop.utils.ProductDataNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("tree")
    public Page<ProductsTreeDTO> getTree(@PageableDefault Pageable pageable) {

        Page<Product> productList = service.getAll(pageable);
        ProductDataNode tree = ProductDataNode.makeTree(productList.toList(), new ProductDataNode());

        List<ProductsTreeDTO> resultList = new ArrayList<>();
        for(ProductDataNode child : tree.getChildren())
            resultList.add(buildTreeDTO(child));


        return new PageImpl<ProductsTreeDTO>(resultList);
    }

    public ProductsTreeDTO buildTreeDTO(ProductDataNode tree) {

        ProductsTreeDTO dto = new ProductsTreeDTO();

        dto.setCategory(tree.getData().getProductCategory().getName());
        dto.setName(tree.getData().getName());
        dto.setId(tree.getData().getId());
        dto.setParent(tree.getData().getParentId());
        dto.setOpen(tree.getData().isGroup());

        if (tree.getChildren() != null)
            for (ProductDataNode child : tree.getChildren())
                dto.addToList(buildTreeDTO(child));


        return dto;

    }
}
