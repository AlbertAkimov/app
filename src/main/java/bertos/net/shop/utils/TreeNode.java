package bertos.net.shop.utils;

import bertos.net.shop.model.AbstractEntity;
import bertos.net.shop.utils.inter.Func2;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
@Data
@MappedSuperclass
public class TreeNode<E, N extends TreeNode<E, N>> {

    //protected N parent;
    protected E data;
    protected ArrayList<N> children;

    public TreeNode() {
    }

    public TreeNode(N parent, ArrayList<N> children, E data) {
        //this.parent = parent;
        this.data = data;
        this.children = children;
    }

    public static <E extends AbstractEntity, N extends TreeNode<E, N>> N makeTree(List<E> datas, TypeAdapter<E, N> typeAdapter) {

        N root = typeAdapter.newInstance();
        root.children = new ArrayList<>();

        for(E top : FuncUtils.filter(datas, typeAdapter::isTopLevelItem))
            root.children.add(extractNode(top, root, datas, typeAdapter));

        return root;
    }

    protected static <E extends AbstractEntity, N extends TreeNode<E, N>> N extractNode(E data, N parent, List<E> datas, TypeAdapter<E, N> typeAdapter) {

        N node = typeAdapter.newInstance();
        node.data = data;
        //node.parent = parent;

        List<E> directChildren = FuncUtils.filter(datas, d -> typeAdapter.isChildOf(data, d));

        if(! directChildren.isEmpty()) {
            node.children = new ArrayList<>();

            for(E child : directChildren)
                node.children.add(extractNode(child, node, datas, typeAdapter));

        }

        return node;
    }

    public <R> R reduce(Func2<N, R, R> reducer, R initial) {

        R value = reducer.apply((N) this, initial);

        if(children != null) {
            for(N node : children)
                value = node.reduce(reducer, value);
        }

        return value;
    }
}
