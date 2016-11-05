package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.Objects;
import java.util.UUID;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;
import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;
import de.hsrm.hktn.morsecodetrainer.morse.GeneratedMorseCodeEvent;
import de.hsrm.hktn.morsecodetrainer.morse.IMorseCodeProvider;

/**
 * The registry for challenges
 * 
 * @author Samuel Leisering
 *
 */
public class ToneChallengeRegistry {

    private final IPersistence reg;
    private IMorseCodeProvider mcp;

    /**
     * create a new Registry
     * 
     * @param p
     *            the persistence layer
     * @param mcp
     *            the challenge provider
     */
    public ToneChallengeRegistry(IPersistence p, IMorseCodeProvider mcp) {
        this.reg = p;
        this.mcp = mcp;
    }

    /**
     * create a new challenge for a user
     * 
     * @param user
     *            user
     * @return the created challenge
     * @throws NoSuchUserException
     */
    public ToneChallenge createNewChallence(String user) throws NoSuchUserException {

        GeneratedMorseCodeEvent ch = this.mcp.createChallengeForUser(user);
        reg.registerNewChallenge(user, ch.getChallenge().getId(), ch.getSolution());
        return ch.getChallenge();
    }

    /**
     * respond to a challenge
     * 
     * @param user
     *            the user
     * @param id
     *            the challenge ID
     * @param response
     *            the provided response
     * @return the result
     * @throws NoSuchUserException
     * @throws NoSuchChallengeException
     */
    public boolean respond(String user, UUID id, String response) throws NoSuchUserException, NoSuchChallengeException {
        String challenge = reg.getChallenge(user, id);
        reg.removeChallenge(user, id);
        return Objects.equals(challenge, response);
    }

}
