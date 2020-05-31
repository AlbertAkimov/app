package bertos.net.shop.controllers;

import bertos.net.shop.model.Product;
import bertos.net.shop.services.impl.ProductService;
import bertos.net.shop.utils.Data;
import bertos.net.shop.utils.DataNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 31.05.2020
 * @Description:
 */
@Controller
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @RequestMapping(value = "/list_products", method = RequestMethod.GET)
    public String loadProducts(Model model) {

        List<Product> listProducts = service.getAll();

        List<Data> datas = new ArrayList<>();

        for(Product product : listProducts) {
            Data data = new Data(product.getId(), product.getName(),product.getParentId());
            datas.add(data);
        }

        DataNode tree = DataNode.makeTree(datas, new DataNode());

        model.addAttribute("treeProducts", tree);

        return "main";
    }
}
