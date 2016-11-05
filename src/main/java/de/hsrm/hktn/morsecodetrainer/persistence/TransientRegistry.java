package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;

public class TransientRegistry implements IPersistence {

	private static final Logger logger = Logger.getLogger(TransientRegistry.class.getName());

	private HashMap<String, HashMap<UUID, String>> registry = new HashMap<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hsrm.hktn.morsecodetrainer.persistence.IPersistence#
	 * registerNewChallenge(java.lang.String, java.util.UUID,
	 * java.lang.Character)
	 */
	@Override
	public void registerNewChallenge(String user, UUID id, String c) {
		if (!registry.containsKey(user)) {
			registry.put(user, new HashMap<UUID, String>());
		}
		logger.info("id is " + id);
		registry.get(user).put(id, c);
	}

	@Override
	public String getChallenge(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException {
		checkSanity(user, id);
		return registry.get(user).get(id);
	}

	@Override
	public String removeChallenge(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException {
		checkSanity(user, id);
		return registry.get(user).remove(id);
	}

	private void checkSanity(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException {
		if (!registry.containsKey(user)) {
			throw new NoSuchUserException(user);
		}
		if (!registry.get(user).containsKey(id)) {
			throw new NoSuchChallengeException(user, id);
		}
	}

}
