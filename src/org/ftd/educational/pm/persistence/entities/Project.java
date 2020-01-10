package org.ftd.educational.pm.persistence.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.3 - 12/02/2016
 * 
 * 
 */
@Entity
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 45)
    private String name;
   
    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private boolean system = false;     
    
    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private Boolean blocked = false;     
    
    @Column(nullable = false, length = 45)
    private String company;
    
    @Column(nullable = false)
    private Long statusId;    
    
    @Column(nullable = false)
    private int estimatedWork = 0;
    
    @Column(nullable = false, length = 10)
    private String startDate;
    
    @Column(nullable = false, length = 10)
    private String endDate;
    
    @Column(nullable = false, length = 45)
    private String manager = "Não definido";  
    
    @Column(length = 200)
    private String justifications;   

    @Column(length = 200)
    private String assumptions;    

    @Column(length = 200)
    private String restrictions;
    
    @Column(length = 200)
    private String scratchs;
    
    @Column(length = 200)
    private String acceptanceCriteria;      
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " [ id=" + id + " | name=" + name + " | sistema=" + system + " ]";
    }

    
    /*
        GETTES AND SETTERS MEMBERS ...
    */

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

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public int getEstimatedWork() {
        return estimatedWork;
    }

    public void setEstimatedWork(int estimatedWork) {
        this.estimatedWork = estimatedWork;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getJustifications() {
        return justifications;
    }

    public void setJustifications(String justifications) {
        this.justifications = justifications;
    }

    public String getAssumptions() {
        return assumptions;
    }

    public void setAssumptions(String assumptions) {
        this.assumptions = assumptions;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getScratchs() {
        return scratchs;
    }

    public void setScratchs(String scratchs) {
        this.scratchs = scratchs;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }
 
}
