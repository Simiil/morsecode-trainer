package de.hsrm.hktn.morsecodetrainer.morse;

public interface IMorseCodeProvider {
	public GeneratedMorseCodeEvent createChallengeForUser(String user);

}
