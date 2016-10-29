package de.hsrm.hktn.morsecodetrainer.morse;

import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;

public interface IMorseCodeProvider {
	public GeneratedMorseCodeEvent createChallengeForUser(String user);

}
