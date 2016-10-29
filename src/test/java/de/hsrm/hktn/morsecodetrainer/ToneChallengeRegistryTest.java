package de.hsrm.hktn.morsecodetrainer;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import de.hsrm.hktn.morsecodetrainer.model.protocol.EncodedTone;
import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;
import de.hsrm.hktn.morsecodetrainer.morse.GeneratedMorseCodeEvent;
import de.hsrm.hktn.morsecodetrainer.morse.IMorseCodeProvider;
import de.hsrm.hktn.morsecodetrainer.persistence.IPersistence;
import de.hsrm.hktn.morsecodetrainer.persistence.ToneChallengeRegistry;

public class ToneChallengeRegistryTest {

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
			GeneratedMorseCodeEvent expected = new GeneratedMorseCodeEvent(challenge, "A");
			Mockito.when(morseProvider.createChallengeForUser("testUser")).thenReturn(expected);
			Mockito.when(persistence.getChallenge("testUser", id)).thenReturn("A");
			Mockito.when(persistence.removeChallenge("testUser", id)).thenReturn("A");

			ToneChallenge ch = tcr.createNewChallence("testUser");

			assertEquals(ch.id, id);
			assertEquals(ch.character.tone, tone.tone);

			boolean respond = tcr.respond("testUser", id, "A");
			assertTrue(respond);
			Mockito.verify(persistence, Mockito.times(1)).registerNewChallenge("testUser", id, "A");
			
		} catch (NoSuchUserException e) {
			e.printStackTrace();
		}
	}
}
