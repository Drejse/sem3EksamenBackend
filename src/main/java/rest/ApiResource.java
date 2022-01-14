package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ConferenceDTO;
import dtos.TalkDTO;
import dtos.TalkListDTO;
import entities.Talk;
import entities.User;
import facades.UserFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class ApiResource {
     private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final UserFacade UF = UserFacade.getUserFacade(EMF);
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
 
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u",entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("conf")
    public Response getAllConferences() throws Exception{
        return Response.ok(gson.toJson(UF.getAllConferences()),MediaType.APPLICATION_JSON).build();
       
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("talks")
    public Response getAllTalks() throws Exception{
        return Response.ok(gson.toJson(UF.getAllTalks()),MediaType.APPLICATION_JSON).build();
       
    }
    
    /*
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTalksFromSpecifikSpeaker(@PathParam("name")String name) throws Exception {
        return Response.ok(gson.toJson(UF.getTalksFromSpecifikSpeaker(name)),MediaType.APPLICATION_JSON).build();
    }
*/
    
    
    @Path("createconf")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ConferenceDTO create(ConferenceDTO u) throws Exception {
        return UF.create(u);
    }
    
    @Path("createtalk")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TalkDTO create(TalkDTO u) throws Exception {
        return UF.createTalk(u);
    }
    
    
    @DELETE
    @Path("deletetalk/{id}")
    public String deleteTalk(@PathParam("id")int id) throws Exception{
        return gson.toJson(UF.deleteTalk(id));
    }
  
}