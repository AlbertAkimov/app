package bertos.net.shop.utils;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
public interface TypeAdapter<T, N extends TreeNode<T, N>> {
    N newInstance();
    boolean isChildOf(T parentNodeData, T childNodeData);
    boolean isTopLevelItem(T data);
}
