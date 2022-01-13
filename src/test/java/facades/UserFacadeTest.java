
import dtos.ConferencesDTO;
import entities.Conference;
import entities.Role;
import entities.User;
import facades.UserFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

public class UserFacadeTest {
    
    private static EntityManagerFactory emf;
    private static UserFacade facade; 
    
    User u1,u2,u3;

    Conference c1,c2,c3;
    
    public UserFacadeTest() {}
    
    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = UserFacade.getUserFacade(emf);
    }
    
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
 
   
            c1 = new Conference("CES","Las Vegas",100,"12-01-22","12:00");
            c2 = new Conference("E3","LA",200,"12-01-22","12:00");
            c3 = new Conference("Apple","Dubai",300,"12-01-22","12:00");
        try {
            em.getTransaction().begin();
          
           
        

            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }  
    }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
//        emf.close();
    }
    
    @Test
    void getAllConferences() throws Exception {
        System.out.println("Testing getAllConferences(ConferenceDTO uDTO");
        int expected = 3;
        ConferencesDTO result = facade.getAllConferences();
        assertEquals(expected,result.getAll().size());
        System.out.println(result.getAll());
    }
    
    }
    
    
    

