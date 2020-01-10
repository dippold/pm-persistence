
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
 * @version 1.0.0 - 11/02/16
 * 
 */
@Entity
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long projectId;     

    @Column(nullable = false)
    private Long workPackageId; 

    @Column(nullable = false, length = 45)
    private String group;
    
    @Column(unique = true, nullable = false, length = 45)
    private String name;    

    @Column(nullable = false, length = 45)
    private String skill;    

    @Column(nullable = false, length = 10)
    private String startDate;
    
    @Column(nullable = false, length = 10)
    private String endDate;
    
    @Column(nullable = false)
    private int estimatedWork = 0;
    
    @Column(nullable = false)
    private Long userId;  
    
    @Column(nullable = false, length = 45)
    private String state = "Planejada"; 
    
    @Column(nullable = false, length = 200)
    private String progressObservation;    
    
    @Column(nullable = false)
    private int completeness = 0;    

    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private Boolean completed = false;     

    @Column(nullable = false, columnDefinition = "TINYINT(1) default false")
    private Boolean issue = false;
    
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
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() 
                + " [ id=" + id + " | name=" + name + " | system=" + system + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getWorkPackageId() {
        return workPackageId;
    }

    public void setWorkPackageId(Long workPackageId) {
        this.workPackageId = workPackageId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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

    public int getEstimatedWork() {
        return estimatedWork;
    }

    public void setEstimatedWork(int estimatedWork) {
        this.estimatedWork = estimatedWork;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProgressObservation() {
        return progressObservation;
    }

    public void setProgressObservation(String progressObservation) {
        this.progressObservation = progressObservation;
    }

    public int getCompleteness() {
        return completeness;
    }

    public void setCompleteness(int completeness) {
        this.completeness = completeness;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
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

    public Boolean getIssue() {
        return issue;
    }

    public void setIssue(Boolean issue) {
        this.issue = issue;
    }    
    
}
