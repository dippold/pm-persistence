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
 * @version 1.0.0
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "WorkPackage.findby.project",
            query = "SELECT o FROM WorkPackage o WHERE o.projectId = :project"),
    @NamedQuery(name = "WorkPackage.findby.status",
            query = "SELECT o FROM WorkPackage o WHERE o.projectId = :project AND o.statusId = :status")
})

public class WorkPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long projectId;     

    @Column(nullable = false, length = 45)
    private String pooler;
    
    @Column(nullable = false, length = 45)
    private String name;    

    @Column(length = 200)
    private String description;     

    @Column(length = 200)
    private String descriptionConsultancyActivities;     

    @Column(length = 200)
    private String descriptionTiActivities; 

    @Column(length = 200)
    private String descriptionBasisActivities;     
    
    @Column(length = 200)
    private String descriptionBusinessActivities;     
    
    @Column(length = 200)
    private String assumptions;    

    @Column(length = 200)
    private String restrictions;
    
    @Column(length = 200)
    private String scratchs;
    
    @Column(length = 200)
    private String acceptanceCriteria;
    
    @Column(length = 200)
    private String skills;    

    @Column(nullable = false, length = 10)
    private String startDate;
    
    @Column(nullable = false, length = 10)
    private String endDate;
    
    @Column(nullable = false)
    private int estimatedWork = 0;
    
    @Column(nullable = false)
    private Long userId;  
    
    @Column(nullable = false)
    private Long statusId; 
    
    @Column(nullable = false, length = 200)
    private String progressObservations;   
    
    @Column(length = 200)
    private String otherRelevantInformation;     
    
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
        if (!(object instanceof WorkPackage)) {
            return false;
        }
        WorkPackage other = (WorkPackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getName() 
                + " [ id=" + id + " | name=" + name +  " | system=" + system + " ]";
    }

    
    /**
     * getters and setters
     * @return 
     */
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionConsultancyActivities() {
        return descriptionConsultancyActivities;
    }

    public void setDescriptionConsultancyActivities(String descriptionConsultancyActivities) {
        this.descriptionConsultancyActivities = descriptionConsultancyActivities;
    }

    public String getDescriptionTiActivities() {
        return descriptionTiActivities;
    }

    public void setDescriptionTiActivities(String descriptionTiActivities) {
        this.descriptionTiActivities = descriptionTiActivities;
    }

    public String getDescriptionBasisActivities() {
        return descriptionBasisActivities;
    }

    public void setDescriptionBasisActivities(String descriptionBasisActivities) {
        this.descriptionBasisActivities = descriptionBasisActivities;
    }

    public String getDescriptionBusinessActivities() {
        return descriptionBusinessActivities;
    }

    public void setDescriptionBusinessActivities(String descriptionBusinessActivities) {
        this.descriptionBusinessActivities = descriptionBusinessActivities;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
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

    public String getProgressObservations() {
        return progressObservations;
    }

    public void setProgressObservations(String progressObservations) {
        this.progressObservations = progressObservations;
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

    public Boolean getIssue() {
        return issue;
    }

    public void setIssue(Boolean issue) {
        this.issue = issue;
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

    public String getPooler() {
        return pooler;
    }

    public void setPooler(String pooler) {
        this.pooler = pooler;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getOtherRelevantInformation() {
        return otherRelevantInformation;
    }

    public void setOtherRelevantInformation(String otherRelevantInformation) {
        this.otherRelevantInformation = otherRelevantInformation;
    }    
    
}
