package de.hsrm.hktn.morsecodetrainer.api.morse;

import java.util.UUID;

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
import de.hsrm.hktn.morsecodetrainer.model.Acknowledgement;
import de.hsrm.hktn.morsecodetrainer.model.ToneChallenge;
import de.hsrm.hktn.morsecodetrainer.model.ToneResponse;
import de.hsrm.hktn.morsecodetrainer.persistence.ToneChallengeRegistry;

@Path("morse/game/gettone")
public class GameTone {

	@Inject
	public ServletContext context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{user}")
	public ToneChallenge getNextTone(@PathParam("user") String user) throws NoSuchUserException {
		System.out.println("get tone for user " + user);
		ToneChallengeRegistry reg = (ToneChallengeRegistry) context.getAttribute(ContextListener.CHALLENGES);
		return reg.createNewChallence(user);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{user}")
	public Acknowledgement respond(@PathParam("user") String user, ToneResponse tr) {
		try {
			ToneChallengeRegistry reg = (ToneChallengeRegistry) context.getAttribute(ContextListener.CHALLENGES);
			return new Acknowledgement(reg.respond(user, UUID.fromString(tr.id), tr.character.charAt(0)));
		} catch (NoSuchUserException | NoSuchChallengeException e) {
			e.printStackTrace();
			throw new InternalServerErrorException();
		}

	}
}
