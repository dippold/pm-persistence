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
import org.ftd.educational.pm.persistence.entities.WorkPackage;

/**
 *
 * @author Fabio Tavares Dippold
 *
 */
public class WorkPackageJpaController implements Serializable {

    public WorkPackageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WorkPackage workPackage) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(workPackage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WorkPackage workPackage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            workPackage = em.merge(workPackage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = workPackage.getId();
                if (findWorkPackage(id) == null) {
                    throw new NonexistentEntityException("The workPackage with id " + id + " no longer exists.");
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
            WorkPackage workPackage;
            try {
                workPackage = em.getReference(WorkPackage.class, id);
                workPackage.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The workPackage with id " + id + " no longer exists.", enfe);
            }
            em.remove(workPackage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<WorkPackage> findWorkPackageEntities() {
        return findWorkPackageEntities(true, -1, -1);
    }

    public List<WorkPackage> findWorkPackageEntities(int maxResults, int firstResult) {
        return findWorkPackageEntities(false, maxResults, firstResult);
    }

    private List<WorkPackage> findWorkPackageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WorkPackage.class));
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

    public WorkPackage findWorkPackage(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WorkPackage.class, id);
        } finally {
            em.close();
        }
    }

    public int getWorkPackageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WorkPackage> rt = cq.from(WorkPackage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<WorkPackage> findWorkPackageByProject(Long projectId, Long statusId) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("WorkPackage.findby.status");
            q.setParameter("project", projectId);
            q.setParameter("status", statusId);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<WorkPackage> findWorkPackageByProject(Long projectId) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("WorkPackage.findby.project");
            q.setParameter("project", projectId);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
