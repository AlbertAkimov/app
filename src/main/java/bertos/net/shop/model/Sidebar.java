package bertos.net.shop.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */

@Entity
@Table(name = "sidebar")
@Data
@ToString
public class Sidebar extends AbstractEntity {

    @Column(name = "id_parent")
    private Long parentId;

    @Column(name = "id_sidebar")
    private String sidebarId;

    @Column(name = "value")
    private String value;

    @Column(name = "icon")
    private String icon;

    @Column(name = "is_group")
    private Boolean isGroup;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parent")
    private List<Sidebar> data;
}
