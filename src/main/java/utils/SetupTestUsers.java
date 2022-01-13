package utils;


import entities.Conference;
import entities.Role;
import entities.Speaker;
import entities.Talk;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    User user = new User("user", "123");
    User admin = new User("admin", "123");
    
    Speaker speaker = new Speaker("Frank","Computer Sience","Male");
    Speaker speaker2 = new Speaker("Mathias","Coach","Male");
    Conference conference = new Conference("Computer sience", "Copenhagen",250,"12-01-2022","12:00");
    Conference conference2 = new Conference("Bodybuilding 101", "Herlev",250,"15-01-2022","13:00");
    Conference conference3 = new Conference("Get Shredded AF", "Herlev",250,"15-01-2022","15:00");
    Talk talk = new Talk("Development","Computer,Noter","120",conference);
    Talk talk2 = new Talk("Workout","Bænk, Vægte","45",conference2);
    Talk talk3 = new Talk("Workout","Diagrammer","45",conference3);
   
    speaker.addTalks(talk);
    speaker2.addTalks(talk2);
    speaker2.addTalks(talk3);
    
 
    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    
    
    em.persist(conference);
    em.persist(talk);
    em.persist(speaker);
    
     em.persist(conference2);
    em.persist(talk2);
    em.persist(speaker2);
    
      em.persist(conference3);
    em.persist(talk3);
 
     em.getTransaction().commit();
    em.close();
    
    
   
  }

}
