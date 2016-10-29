package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.UUID;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;

public interface IPersistence {

	void registerNewChallenge(String user, UUID id, String c) throws NoSuchUserException;

	String getChallenge(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException;
	
	String removeChallenge(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException;
	
}