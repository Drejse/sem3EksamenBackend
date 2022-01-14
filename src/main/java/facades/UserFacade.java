package facades;



import dtos.ConferenceDTO;
import dtos.ConferencesDTO;
import dtos.SpeakerDTO;
import dtos.SpeakersDTO;
import dtos.TalkDTO;
import dtos.TalkListDTO;
import entities.Conference;
import entities.Speaker;
import entities.Talk;
import entities.User;
import errorhandling.API_Exception;
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
    
    public TalkListDTO getAllTalks() throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Talk> listOfTalks;
        TypedQuery<Talk> query = em.createQuery("SELECT t FROM Talk t",Talk.class);
        listOfTalks = query.getResultList();
        return new TalkListDTO (listOfTalks);
        
    } 
    
     public SpeakersDTO getAllSpeakers() throws Exception {
        EntityManager em = emf.createEntityManager();
        List<Speaker> listOfSpeakers;
        TypedQuery<Speaker> query = em.createQuery("SELECT s FROM Speaker s",Speaker.class);
        listOfSpeakers = query.getResultList();
        return new SpeakersDTO (listOfSpeakers);
        
    } 
    
    /*
    public TalkListDTO getTalksFromSpecifikSpeaker(String name) throws Exception{
        EntityManager em = emf.createEntityManager();
        List<Talk> listOfTalks;
        TypedQuery<Talk> query = em.createQuery("SELECT t FROM Talk t JOIN t.speaker.name s WHERE s.speaker.name = :name",Talk.class);
        query.setParameter("name",name);
        listOfTalks = query.getResultList();
        return new TalkListDTO(listOfTalks);
        
    }*/
    
    
    
    
    public ConferenceDTO create(ConferenceDTO c) throws Exception {
        EntityManager em = emf.createEntityManager();
        Conference conference = null;
        try{
            conference = new Conference(c);
            em.getTransaction().begin();
            em.persist(conference);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return new ConferenceDTO(conference);
       
    }
    
     public TalkDTO createTalk(TalkDTO t) throws Exception {
        EntityManager em = emf.createEntityManager();
        Talk talk = null;
        try{
            talk = new Talk(t);
            em.getTransaction().begin();
            em.persist(talk);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return new TalkDTO(talk);
        
     }
     
        public SpeakerDTO createSpeaker(SpeakerDTO s) throws Exception {
        EntityManager em = emf.createEntityManager();
        Speaker speaker = null;
        try{
            speaker = new Speaker(s);
            em.getTransaction().begin();
            em.persist(speaker);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return new SpeakerDTO(speaker);
    
       
     }
        
        
   public TalkDTO deleteTalk(long id) throws Exception{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
           Talk talk = em.find(Talk.class,id);
            if(talk == null){
                throw new Exception("could not delete, no id found");
            }
            em.remove(talk);
            em.getTransaction().commit();
            return new TalkDTO(talk);
        }
        finally{
            em.close();
        }
    } 
    
}
