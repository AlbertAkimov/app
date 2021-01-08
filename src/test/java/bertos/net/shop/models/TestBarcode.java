package bertos.net.shop.models;

import bertos.net.shop.Application;
import bertos.net.shop.model.Barcode;
import bertos.net.shop.services.BarcodeService;
import bertos.net.shop.utils.BarcodeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * @Authot: Albert Akimov
 * @Date: 01.01.2021
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootConfiguration
@ContextConfiguration
public class TestBarcode extends AbstractTestCRUD<Barcode, BarcodeService> {

    @Test
    public void generateAndSaveBarcodeToFile() {

        Barcode result = service.getById(29L);

        BufferedImage image = BarcodeUtils.createEAN13(result.getCode());
        String barcodeBase64 = BarcodeUtils.encodeBarcodeToBase64(image);

        byte[] barcodeByte = BarcodeUtils.decodeBarcodeFromBase64(barcodeBase64);

        ByteArrayInputStream stream = new ByteArrayInputStream(barcodeByte);

        try {
            image = ImageIO.read(stream);
            stream.close();

            File outFile = new File("C:/Users/Its_s/OneDrive/Рабочий стол/image.png");
            ImageIO.write(image, "png", outFile);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
