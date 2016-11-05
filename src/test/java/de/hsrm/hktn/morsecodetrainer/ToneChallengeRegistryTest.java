package de.hsrm.hktn.morsecodetrainer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import de.hsrm.hktn.morsecodetrainer.model.protocol.EncodedTone;
import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;
import de.hsrm.hktn.morsecodetrainer.morse.GeneratedMorseCodeEvent;
import de.hsrm.hktn.morsecodetrainer.morse.IMorseCodeProvider;
import de.hsrm.hktn.morsecodetrainer.persistence.IPersistence;
import de.hsrm.hktn.morsecodetrainer.persistence.ToneChallengeRegistry;

public class ToneChallengeRegistryTest {
	private static final String TEST_TONE = "A";

	private static final String TEST_USER = "testUser";

	private static final Logger logger = Logger.getLogger(ToneChallengeRegistryTest.class.getName());

	private ToneChallengeRegistry tcr;
	private IPersistence persistence;
	private IMorseCodeProvider morseProvider;

	@Before
	public void setUp() {
		persistence = Mockito.mock(IPersistence.class);
		morseProvider = Mockito.mock(IMorseCodeProvider.class);
		this.tcr = new ToneChallengeRegistry(persistence, morseProvider);
	}

	@Test
	public void basicChallengeTest() throws NoSuchChallengeException {
		try {
			EncodedTone tone = new EncodedTone(false, true);
			UUID id = UUID.randomUUID();
			ToneChallenge challenge = new ToneChallenge(tone, id);
			GeneratedMorseCodeEvent expected = new GeneratedMorseCodeEvent(challenge, TEST_TONE);
			Mockito.when(morseProvider.createChallengeForUser(TEST_USER)).thenReturn(expected);
			Mockito.when(persistence.getChallenge(TEST_USER, id)).thenReturn(TEST_TONE);
			Mockito.when(persistence.removeChallenge(TEST_USER, id)).thenReturn(TEST_TONE);

			ToneChallenge ch = tcr.createNewChallence(TEST_USER);

			assertEquals(ch.id, id);
			assertEquals(ch.character.tone, tone.tone);

			boolean respond = tcr.respond(TEST_USER, id, TEST_TONE);
			assertTrue(respond);
			Mockito.verify(persistence, Mockito.times(1)).registerNewChallenge(TEST_USER, id, TEST_TONE);

		} catch (NoSuchUserException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
