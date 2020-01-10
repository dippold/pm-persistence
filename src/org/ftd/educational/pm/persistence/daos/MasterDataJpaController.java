package org.ftd.educational.pm.persistence.daos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.ftd.educational.pm.persistence.daos.exceptions.NonexistentEntityException;
import org.ftd.educational.pm.persistence.entities.MasterData;
import org.ftd.educational.pm.persistence.entities.User;

/**
 *
 * @author Fabio Tavares Dippold
 * 
 * 
 */
public class MasterDataJpaController implements Serializable {

    public MasterDataJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MasterData masterData) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(masterData);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MasterData masterData) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            masterData = em.merge(masterData);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = masterData.getId();
                if (findMasterData(id) == null) {
                    throw new NonexistentEntityException("The masterData with id " + id + " no longer exists.");
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
            MasterData masterData;
            try {
                masterData = em.getReference(MasterData.class, id);
                masterData.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The masterData with id " + id + " no longer exists.", enfe);
            }
            em.remove(masterData);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MasterData> findMasterDataEntities() {
        return findMasterDataEntities(true, -1, -1);
    }

    public List<MasterData> findMasterDataEntities(int maxResults, int firstResult) {
        return findMasterDataEntities(false, maxResults, firstResult);
    }

    private List<MasterData> findMasterDataEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MasterData.class));
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

    public MasterData findMasterData(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MasterData.class, id);
        } finally {
            em.close();
        }
    }

    public int getMasterDataCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MasterData> rt = cq.from(MasterData.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     * METODOS NÃO GERADOS PELA IDE NETBEANS...
     * 
     */    
    
    /**
     * findByName
     * @param name
     * @return MasterData
     * @throws NoResultException 
     */
    public MasterData findByName(String name) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (MasterData) em.createNamedQuery("MasterData.findby.name")
                    .setParameter("name", name)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }    
}
