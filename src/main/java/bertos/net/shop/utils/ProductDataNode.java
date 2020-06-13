package bertos.net.shop.utils;

import bertos.net.shop.model.Product;
import org.springframework.stereotype.Component;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
@Component
public class ProductDataNode extends TreeNode<Product, ProductDataNode> implements TypeAdapter<Product, ProductDataNode> {

    @Override
    public ProductDataNode newInstance() {
        return new ProductDataNode();
    }

    @Override
    public boolean isChildOf(Product parentNodeData, Product childNodeData) {
        return parentNodeData.getId().equals(childNodeData.getParentId());
    }

    @Override
    public boolean isTopLevelItem(Product data) {
        return data.getParentId() == 0;
    }

    @Override
    public String toString() {
        return "DataNode{" +
                "data=" + data.getName() +
                '}';
    }
}
