package bertos.net.shop.utils;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Authot: Albert Akimov
 * @Date: 01.01.2021
 * @Description:
 */

public class BarcodeUtils {

    public static BufferedImage createEAN13(String barcode) {

        BufferedImage image = null;
        Font font = new Font("Helvetica", Font.PLAIN, 10);

        try {

            Barcode result = BarcodeFactory.createEAN13(barcode);
            result.setFont(font);
            image = BarcodeImageHandler.getImage(result);

        } catch (BarcodeException | OutputException e) {
            e.printStackTrace();
        } finally {
            assert image != null;
            image.flush();
        }

        return image;
    }

    public static String encodeBarcodeToBase64(BufferedImage barcode) {

        String result = "";

        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {

            ImageIO.write(barcode, "png", stream);
            result = Base64Utils.encodeToString(stream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static byte[] decodeBarcodeFromBase64(String barcode) {
        return Base64Utils.decodeFromString(barcode);
    }
}
