package bertos.net.shop.utils;

import bertos.net.shop.model.AbstractEntity;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
public interface TypeAdapter<T extends AbstractEntity, N extends TreeNode<T, N>> {
    N newInstance();
    boolean isChildOf(T parentNodeData, T childNodeData);
    boolean isTopLevelItem(T data);
}
