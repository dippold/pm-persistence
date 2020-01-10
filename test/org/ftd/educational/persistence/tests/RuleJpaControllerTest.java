package org.ftd.educational.persistence.tests;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.ftd.educational.pm.persistence.daos.RuleJpaController;
import org.ftd.educational.pm.persistence.entities.Rule;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0 - 03/02/2016
 * 
 */
public class RuleJpaControllerTest {
    
     /**
     * Test of find method, of class RuleJpaController.
     */
    @Test
    public void testFindRule_Long() {
        System.out.println("testFindRule_Long(Long id)...");
        final String PERSISTENCE_UNIT_NAME = "PmPersistencePU";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        RuleJpaController dao = new RuleJpaController(factory);
        String id = "1";
        String expResult = "Admin";
        Rule result = dao.findRule(Long.parseLong(id));
                
        System.out.println("expResult: " + expResult);
        System.out.println("result: " + result.getName());
        
        assertEquals(expResult, result.getName());
    }
    
    /**
     * METODOS GERADOS....
     */
    
    public RuleJpaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
}
