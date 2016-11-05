package de.hsrm.hktn.morsecodetrainer.morse.internal;

import java.util.UUID;
import java.util.logging.Logger;

import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;
import de.hsrm.hktn.morsecodetrainer.morse.GeneratedMorseCodeEvent;
import de.hsrm.hktn.morsecodetrainer.morse.IMorseCodeProvider;
import de.hsrm.hktn.morsecodetrainer.persistence.Util;

public class SimpleMorseCodeProvider implements IMorseCodeProvider {

	private static final Logger logger = Logger.getLogger(SimpleMorseCodeProvider.class.getName());

	@Override
	public GeneratedMorseCodeEvent createChallengeForUser(String user) {
		UUID id = UUID.randomUUID();
		Character t = Util.random();
		logger.info("create challenge " + t);
		ToneChallenge challenge = new ToneChallenge(Util.mapToTone(t), id);
		return new GeneratedMorseCodeEvent(challenge, t);
	}

}
