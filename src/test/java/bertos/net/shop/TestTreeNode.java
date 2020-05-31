package bertos.net.shop;

import bertos.net.shop.model.Product;
import bertos.net.shop.services.impl.ProductService;
import bertos.net.shop.utils.Data;
import bertos.net.shop.utils.DataNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootConfiguration
@ContextConfiguration
public class TestTreeNode  {

    @Autowired
    private ProductService service;

    @Test
    public void getAll() {

        List<Product> products = service.getAll();
        List<Data> datas = new ArrayList<>();

        for(Product product : products) {
            Data data = new Data(product.getId(), product.getName(),product.getParentId());
            datas.add(data);
        }

        DataNode tree = DataNode.makeTree(datas, new DataNode());

        System.out.println("");
    }

}
