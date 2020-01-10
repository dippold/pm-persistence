
package org.ftd.educational.persistence.tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.ftd.educational.pm.persistence.daos.UserJpaController;
import org.ftd.educational.pm.persistence.entities.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fabio Tavares Dippold
 * 
 */
public class UserJpaControllerTest {
    
    public UserJpaControllerTest() {
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

    /**
     * Test of findUser method, of class UserJpaController.
     */
    @Test
    public void testFindUser_String_String() {
        System.out.println("testFindUser(String email, String passwd)...");
        final String PERSISTENCE_UNIT_NAME = "PmPersistencePU";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserJpaController dao = new UserJpaController(factory);
        String email = "dippold.br@gmail.com";
        String passwd = "pm@123";        
        String expResult = "dippold.br@gmail.com";
        User result = dao.findUser(email, passwd);
                
        System.out.println("expResult: " + expResult);
        System.out.println("result: " + result.getEmail());
        
        assertEquals(expResult, result.getEmail());
    }
    
}
