package org.ftd.educational.pm.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.2 - 04/02/2016
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "MenuItem.findBy.group",
            query = "SELECT o FROM MenuItem o WHERE o.groupName =:name ORDER BY o.orderId"),
    @NamedQuery(name = "MenuItem.findAll",
            query = "SELECT o FROM MenuItem o ORDER BY o.groupOrderId,o.groupName, o.orderId")
})

public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 45)    
    private String groupName;    

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private int groupOrderId;    
    
    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private int type;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private int orderId;
    
    @Column(nullable = false, length = 45)
    private String name;
    
    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private boolean system = false;
    
    @Column(length = 45)
    private String resource;    

    @Column(nullable = false, length = 45)
    private String roleIds;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+ " [ id=" + id + " ]";
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public int getGroupOrderId() {
        return groupOrderId;
    }

    public void setGroupOrderId(int groupOrderId) {
        this.groupOrderId = groupOrderId;
    }
    
}
