package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.Objects;
import java.util.UUID;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;
import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;
import de.hsrm.hktn.morsecodetrainer.morse.GeneratedMorseCodeEvent;
import de.hsrm.hktn.morsecodetrainer.morse.IMorseCodeProvider;

public class ToneChallengeRegistry {

	private final IPersistence reg;
	private IMorseCodeProvider mcp;

	public ToneChallengeRegistry(IPersistence p, IMorseCodeProvider mcp) {
		this.reg = p;
		this.mcp = mcp;
	}

	public ToneChallenge createNewChallence(String user) throws NoSuchUserException {
		
		GeneratedMorseCodeEvent ch = this.mcp.createChallengeForUser(user);
		reg.registerNewChallenge(user, ch.challenge.id, ch.solution);
		return ch.challenge;
	}

	public boolean respond(String user, UUID id, String response)
			throws NoSuchUserException, NoSuchChallengeException {
		String challenge = reg.getChallenge(user, id);
		reg.removeChallenge(user, id);
		return Objects.equals(challenge, response);
	}

}
