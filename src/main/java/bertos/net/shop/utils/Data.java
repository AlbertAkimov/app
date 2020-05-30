package bertos.net.shop.utils;

/**
 * @Authot: Albert Akimov
 * @Date: 17.05.2020
 * @Description:
 */
public class Data {

    protected Long id;
    protected String name;
    protected Long parentId;

    public Data(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
