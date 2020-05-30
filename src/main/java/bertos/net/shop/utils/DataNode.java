package bertos.net.shop.utils;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
public class DataNode extends TreeNode<Data, DataNode> implements TypeAdapter<Data, DataNode> {

    @Override
    public DataNode newInstance() {
        return new DataNode();
    }

    @Override
    public boolean isChildOf(Data parentNodeData, Data childNodeData) {
        return parentNodeData.id.equals(childNodeData.parentId);
    }

    @Override
    public boolean isTopLevelItem(Data data) {
        return data.parentId == 0;
    }

    @Override
    public String toString() {
        return "DataNode{" +
                "data=" + data.name +
                '}';
    }
}
