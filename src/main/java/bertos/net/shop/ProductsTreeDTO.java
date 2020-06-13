package bertos.net.shop;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 07.06.2020
 * @Description:
 */
@Data
public class ProductsTreeDTO {

    private Long id;
    private Long parent;
    private boolean open;
    private String name;
    private String category;
    private List<ProductsTreeDTO> data = new ArrayList<>();

    public ProductsTreeDTO() {
    }

    public void addToList(ProductsTreeDTO dto) {
        data.add(dto);
    }
}
