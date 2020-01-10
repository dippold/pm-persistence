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
import org.ftd.educational.pm.persistence.entities.MenuItem;

/**
 *
 * @author fabiot
 */
public class MenuItemJpaController implements Serializable {

    public MenuItemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MenuItem menuItem) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(menuItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MenuItem menuItem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            menuItem = em.merge(menuItem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = menuItem.getId();
                if (findMenuItem(id) == null) {
                    throw new NonexistentEntityException("The menuItem with id " + id + " no longer exists.");
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
            MenuItem menuItem;
            try {
                menuItem = em.getReference(MenuItem.class, id);
                menuItem.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The menuItem with id " + id + " no longer exists.", enfe);
            }
            em.remove(menuItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MenuItem> findMenuItemEntities() {
        return findMenuItemEntities(true, -1, -1);
    }

    public List<MenuItem> findMenuItemEntities(int maxResults, int firstResult) {
        return findMenuItemEntities(false, maxResults, firstResult);
    }

    private List<MenuItem> findMenuItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MenuItem.class));
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

    public MenuItem findMenuItem(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MenuItem.class, id);
        } finally {
            em.close();
        }
    }

    public int getMenuItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MenuItem> rt = cq.from(MenuItem.class);
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
    
    public List<MenuItem> findMenuItem(String groupName) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("MenuItem.findBy.group");
            q.setParameter("name", groupName);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<MenuItem> findAllMenuItem() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("MenuItem.findAll");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
}
