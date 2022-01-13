package facades;



import dtos.ConferenceDTO;
import dtos.ConferencesDTO;
import entities.Conference;
import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import security.errorhandling.AuthenticationException;

/**
 * @author madr1402@hotmail.com
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    
    public ConferencesDTO getAllConferences() throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Conference> conferenceList;
        TypedQuery<Conference> query = em.createQuery("SELECT c FROM Conference c",Conference.class);
        conferenceList = query.getResultList();
        return new ConferencesDTO(conferenceList);
        
    } 
    
    
    
    
    
    
    
}
