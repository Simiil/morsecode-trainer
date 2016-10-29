package de.hsrm.hktn.morsecodetrainer.api.morse;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import de.hsrm.hktn.morsecodetrainer.persistence.JPAPersistenceRegistry;
import de.hsrm.hktn.morsecodetrainer.persistence.ToneChallengeRegistry;

public class ContextListener implements ServletContextListener {

	public static final String PERSISTENCE = "persistence";

	public static final String CHALLENGES = "challenges";
	

	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("initialize Persistence...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bmorsecodetrainer");
		System.out.println("initialize Persistence "+emf);
		ServletContext context = event.getServletContext();
		try {
			JPAPersistenceRegistry jpr = new JPAPersistenceRegistry(emf);
			ToneChallengeRegistry tcr = new ToneChallengeRegistry(jpr);
			context.setAttribute(PERSISTENCE, jpr);
			context.setAttribute(CHALLENGES, tcr);
		} catch (Exception ex) {
			System.out.println("Couldn’t create bookstore database bean: " + ex.getMessage());
		}
	}

}
