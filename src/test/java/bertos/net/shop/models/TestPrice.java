package bertos.net.shop.models;

import bertos.net.shop.Application;
import bertos.net.shop.model.Price;
import bertos.net.shop.model.Product;
import bertos.net.shop.model.TypePrice;
import bertos.net.shop.services.ProductService;
import bertos.net.shop.services.TypePriceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootConfiguration
@ContextConfiguration
public class TestPrice extends AbstractTestCRUD<Product, ProductService> {

    @Autowired
    private TypePriceService typePriceService;

    @Test
    public void testCase() {

        Product product = service.getById(7L);

        Assert.assertNull(product);

        TypePrice typePrice = typePriceService.getById(1L);

        Assert.assertNull(typePrice);

        Price price = new Price();

        price.setProduct(product);
        price.setTypePrice(typePrice);
        price.setPrice(99.00);

        List<Price> prices = new ArrayList<>();
        prices.add(price);
        product.setPrices(prices);

        service.save(product);

    }
}
