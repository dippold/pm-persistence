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
 * @version 1.0.0 - 04/02/2016
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UserNotification.findBy.user",
            query = "SELECT o FROM UserNotification o WHERE o.userId = :id AND o.wasRead = :state ORDER BY o.id"),
    @NamedQuery(name = "UserNotification.countBy.user",
            query = "SELECT count(o.id) FROM UserNotification o WHERE o.userId = :id AND o.wasRead = :state")
})
public class UserNotification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 45)
    private String notification;
    
    @Column(nullable = false)
    private Long userId;
    
    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private boolean wasRead = false;
    
    @Column(nullable = false, length = 45)
    private String resource;
    
    @Column(nullable = false)
    private Long entityId;        
    
    
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
        if (!(object instanceof UserNotification)) {
            return false;
        }
        UserNotification other = (UserNotification) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[ id=" + id + " | notification=" + notification + " ]";
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isWasRead() {
        return wasRead;
    }

    public void setWasRead(boolean wasRead) {
        this.wasRead = wasRead;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
    
}
