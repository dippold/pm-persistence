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
import org.ftd.educational.pm.persistence.entities.Rule;

/**
 *
 * @author fabiot
 */
public class RuleJpaController implements Serializable {

    public RuleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rule rule) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rule rule) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rule = em.merge(rule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = rule.getId();
                if (findRule(id) == null) {
                    throw new NonexistentEntityException("The rule with id " + id + " no longer exists.");
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
            Rule rule;
            try {
                rule = em.getReference(Rule.class, id);
                rule.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rule with id " + id + " no longer exists.", enfe);
            }
            em.remove(rule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rule> findRuleEntities() {
        return findRuleEntities(true, -1, -1);
    }

    public List<Rule> findRuleEntities(int maxResults, int firstResult) {
        return findRuleEntities(false, maxResults, firstResult);
    }

    private List<Rule> findRuleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rule.class));
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

    public Rule findRule(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rule.class, id);
        } finally {
            em.close();
        }
    }

    public int getRuleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rule> rt = cq.from(Rule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * METODOS NÃO GERADOS PELA IDE NETBEANS...
     * @param name
     * @return 
     */
    public Rule findRule(String name) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (Rule) em.createNamedQuery("Rule.findByName")
                    .setParameter("name", name)
                    .getSingleResult();
        } finally {
            em.close();
        }

    }
}
