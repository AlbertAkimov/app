package bertos.net.shop.model.access;

import bertos.net.shop.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @Authot: Albert Akimov
 * @Date: 30.01.2021
 * @Description:
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "permissions")
@Data
@ToString
public class Permission extends AbstractEntity {

    @Column(name = "permission")
    private String permission;

    @OneToMany(mappedBy = "permission", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<RelationBridgeUserRolePermission> bridges;

}
