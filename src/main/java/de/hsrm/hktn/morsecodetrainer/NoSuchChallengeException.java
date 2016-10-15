package de.hsrm.hktn.morsecodetrainer;

import java.util.UUID;

public class NoSuchChallengeException extends Exception {
	public NoSuchChallengeException(String user, UUID challenge) {
		super(user+": "+String.valueOf(challenge));
	}
}
