package de.hsrm.hktn.morsecodetrainer.api.morse;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;
import de.hsrm.hktn.morsecodetrainer.model.protocol.Acknowledgement;
import de.hsrm.hktn.morsecodetrainer.model.protocol.MorseResponse;
import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;
import de.hsrm.hktn.morsecodetrainer.persistence.ToneChallengeRegistry;

@Path("morse/game/gettone")
public class GameTone {
	
	private static final Logger logger = Logger.getLogger(GameTone.class.getName());

	@Inject
	public ServletContext context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{user}")
	public ToneChallenge getNextTone(@PathParam("user") String user) throws NoSuchUserException {
		logger.info("get tone for user " + user);
		ToneChallengeRegistry reg = (ToneChallengeRegistry) context.getAttribute(ContextListener.CHALLENGES);
		return reg.createNewChallence(user);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{user}")
	public Acknowledgement respond(@PathParam("user") String user, MorseResponse tr) {
		try {
			ToneChallengeRegistry reg = (ToneChallengeRegistry) context.getAttribute(ContextListener.CHALLENGES);
			return new Acknowledgement(reg.respond(user, UUID.fromString(tr.id), tr.character));
		} catch (NoSuchUserException | NoSuchChallengeException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new InternalServerErrorException(e);
		}

	}
}
