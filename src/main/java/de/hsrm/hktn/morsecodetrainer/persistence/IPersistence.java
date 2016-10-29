package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.UUID;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;

public interface IPersistence {

	void registerNewChallenge(String user, UUID id, Character c) throws NoSuchUserException;

	boolean checkAndRemoveChallenge(String user, UUID id, Character test)
			throws NoSuchUserException, NoSuchChallengeException;

}