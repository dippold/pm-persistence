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
 * @version 2.0.0 - 03/02/2016
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.authenticate",
            query = "SELECT o FROM User o WHERE o.email = :email AND o.passwd = :passwd"),
    @NamedQuery(name = "User.findby.email",
            query = "SELECT o FROM User o WHERE o.email = :email"),
    @NamedQuery(name = "User.findby.keyword",
            query = "SELECT o FROM User o WHERE o.name LIKE :keyword ORDER BY o.name"),
    @NamedQuery(name = "User.findby.rule",
            query = "SELECT o FROM User o WHERE o.ruleId = :ruleId ORDER BY o.name")
})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 45)
    private String name;

    @Column(unique = true, nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 20)
    private String passwd;
    
    @Column(nullable = false)
    private Long ruleId;    

    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private Boolean system = false; 

    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private Boolean blocked = false;      
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return this.getClass().getName() 
                + " [ id=" + id + " | name=" + name +  " | email=" +  email 
                +  " | senha=" +  passwd + " | ruleId=" + ruleId + " | system=" + system + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
    
}
