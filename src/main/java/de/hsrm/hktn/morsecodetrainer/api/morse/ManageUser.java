package de.hsrm.hktn.morsecodetrainer.api.morse;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hsrm.hktn.morsecodetrainer.model.persist.User;

/**
 * A (currently simple) endpoint to manage users
 * 
 * @author Samuel Leisering
 *
 */
@Path("morse/user")
public class ManageUser {

    @Inject
    private ServletContext context;

    /**
     * Add a user
     * 
     * @param user
     *            the username
     * @return a response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{user}")
    public Response addUser(@PathParam("user") String user) {
        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute(ContextListener.EMF);
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        try {
            User u = new User();
            u.setUsername(user);
            em.persist(u);
            return Response.ok().build();
        } finally {
            t.commit();
        }

    }
}
