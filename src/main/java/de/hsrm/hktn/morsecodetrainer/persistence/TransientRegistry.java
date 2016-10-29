package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;

public class TransientRegistry implements IPersistence {
	private HashMap<String, HashMap<UUID, Character>> registry = new HashMap<>();

	/* (non-Javadoc)
	 * @see de.hsrm.hktn.morsecodetrainer.persistence.IPersistence#registerNewChallenge(java.lang.String, java.util.UUID, java.lang.Character)
	 */
	@Override
	public void registerNewChallenge(String user, UUID id, Character c){
		if(!registry.containsKey(user)){
			registry.put(user, new HashMap<UUID, Character>());
		}
		System.out.println("id is "+id);
		registry.get(user).put(id, c);
	}
	
	/* (non-Javadoc)
	 * @see de.hsrm.hktn.morsecodetrainer.persistence.IPersistence#checkAndRemoveChallenge(java.lang.String, java.util.UUID, java.lang.Character)
	 */
	@Override
	public boolean checkAndRemoveChallenge(String user, UUID id, Character test) throws NoSuchUserException, NoSuchChallengeException{
		if(!registry.containsKey(user)){
			throw new NoSuchUserException(user);
		}
		if(!registry.get(user).containsKey(id)){
			throw new NoSuchChallengeException(user, id);
		}
		System.out.println("checking id "+id);
		return Objects.equals(registry.get(user).remove(id), test);
	}
	
}
