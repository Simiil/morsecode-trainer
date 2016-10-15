package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.UUID;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;
import de.hsrm.hktn.morsecodetrainer.model.ToneChallenge;

public class ToneChallengeRegistry {

	public static final ToneChallengeRegistry INSTANCE = new ToneChallengeRegistry();

	private TransientRegistry reg = new TransientRegistry();

	private ToneChallengeRegistry() {

	}

	public ToneChallenge createNewChallence(String user) {
		UUID id = UUID.randomUUID();
		Character t = Util.random();
		System.out.println("create challenge "+t);
		ToneChallenge challenge = new ToneChallenge(Util.mapToTone(t), id);
		reg.registerNewChallenge(user, id, t);
		return challenge;
	}

	public boolean respond(String user, UUID id, Character response) throws NoSuchUserException, NoSuchChallengeException {
		return reg.checkAndRemoveChallenge(user, id, response);
	}

}
