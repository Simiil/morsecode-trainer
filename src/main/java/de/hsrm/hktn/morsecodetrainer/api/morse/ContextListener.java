package de.hsrm.hktn.morsecodetrainer.api.morse;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import de.hsrm.hktn.morsecodetrainer.morse.internal.SimpleMorseCodeProvider;
import de.hsrm.hktn.morsecodetrainer.persistence.JPAPersistenceRegistry;
import de.hsrm.hktn.morsecodetrainer.persistence.ToneChallengeRegistry;

/**
 * Listener that initializes the persistence layer
 * 
 * @author Samuel Leisering
 *
 */
public class ContextListener implements ServletContextListener {
    /**
     * Persistence property. Can be used to retrieve the
     * {@link JPAPersistenceRegistry} from
     * {@link ServletContext#getAttribute(String)}
     */
    public static final String PERSISTENCE = "persistence";

    /**
     * Challenge Registry property. Can be used to retrieve the
     * {@link ToneChallengeRegistry} from
     * {@link ServletContext#getAttribute(String)}
     */
    public static final String CHALLENGES = "challenges";

    /**
     * EntityManagerFactory property. Can be used to retrieve the
     * {@link EntityManagerFactory} from
     * {@link ServletContext#getAttribute(String)}
     */
    public static final String EMF = "entifymanagerfactory";

    private static final Logger LOGGER = Logger.getLogger(ContextListener.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        LOGGER.info("context destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        LOGGER.info("initialize Persistence...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bmorsecodetrainer");
        LOGGER.info("initialize Persistence " + emf);
        ServletContext context = event.getServletContext();
        JPAPersistenceRegistry jpr = new JPAPersistenceRegistry(emf);
        ToneChallengeRegistry tcr = new ToneChallengeRegistry(jpr, new SimpleMorseCodeProvider());
        context.setAttribute(EMF, emf);
        context.setAttribute(PERSISTENCE, jpr);
        context.setAttribute(CHALLENGES, tcr);
    }

}
