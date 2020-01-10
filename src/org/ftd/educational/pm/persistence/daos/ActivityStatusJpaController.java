/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftd.educational.pm.persistence.daos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.ftd.educational.pm.persistence.daos.exceptions.NonexistentEntityException;
import org.ftd.educational.pm.persistence.entities.ActivityStatus;

/**
 *
 * @author ftd
 */
public class ActivityStatusJpaController implements Serializable {

    public ActivityStatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ActivityStatus activityStatus) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(activityStatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ActivityStatus activityStatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            activityStatus = em.merge(activityStatus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = activityStatus.getId();
                if (findActivityStatus(id) == null) {
                    throw new NonexistentEntityException("The activityStatus with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ActivityStatus activityStatus;
            try {
                activityStatus = em.getReference(ActivityStatus.class, id);
                activityStatus.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The activityStatus with id " + id + " no longer exists.", enfe);
            }
            em.remove(activityStatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ActivityStatus> findActivityStatusEntities() {
        return findActivityStatusEntities(true, -1, -1);
    }

    public List<ActivityStatus> findActivityStatusEntities(int maxResults, int firstResult) {
        return findActivityStatusEntities(false, maxResults, firstResult);
    }

    private List<ActivityStatus> findActivityStatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ActivityStatus.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ActivityStatus findActivityStatus(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ActivityStatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getActivityStatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ActivityStatus> rt = cq.from(ActivityStatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
