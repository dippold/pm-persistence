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
import org.ftd.educational.pm.persistence.entities.UserNotification;

/**
 *
 * @author fabiot
 */
public class UserNotificationJpaController implements Serializable {

    public UserNotificationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UserNotification userNotification) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(userNotification);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UserNotification userNotification) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            userNotification = em.merge(userNotification);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = userNotification.getId();
                if (findUserNotification(id) == null) {
                    throw new NonexistentEntityException("The userNotification with id " + id + " no longer exists.");
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
            UserNotification userNotification;
            try {
                userNotification = em.getReference(UserNotification.class, id);
                userNotification.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The userNotification with id " + id + " no longer exists.", enfe);
            }
            em.remove(userNotification);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UserNotification> findUserNotificationEntities() {
        return findUserNotificationEntities(true, -1, -1);
    }

    public List<UserNotification> findUserNotificationEntities(int maxResults, int firstResult) {
        return findUserNotificationEntities(false, maxResults, firstResult);
    }

    private List<UserNotification> findUserNotificationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UserNotification.class));
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

    public UserNotification findUserNotification(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UserNotification.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserNotificationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UserNotification> rt = cq.from(UserNotification.class);
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
     * int getUserNotificationCount(Long userId, boolean notificationState)
     *
     * @param userId
     * @param notificationState
     * @return
     */
    public Long getUserNotificationCount(Long userId, boolean notificationState) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("UserNotification.countBy.user");
            q.setParameter("id", userId);
            q.setParameter("state", notificationState);

            return (Long) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    /**
     * List findUserNotificationByUserAndState(Long userId, boolean
     * notificationState)
     *
     * @param userId
     * @param notificationState
     * @return
     */
    public List<UserNotification> findUserNotificationByUser(Long userId, boolean notificationState) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("UserNotification.findBy.user");
            q.setParameter("id", userId);
            q.setParameter("state", notificationState);

            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
