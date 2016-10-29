package de.hsrm.hktn.morsecodetrainer.morse;

import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;

public class GeneratedMorseCodeEvent {
	public final ToneChallenge challenge; 
	public final String solution;
	
	public GeneratedMorseCodeEvent(ToneChallenge challenge, Character solution) {
		this(challenge, solution.toString());
	}
	public GeneratedMorseCodeEvent(ToneChallenge challenge, String solution) {
		this.challenge = challenge;
		this.solution = solution;
	}
}
