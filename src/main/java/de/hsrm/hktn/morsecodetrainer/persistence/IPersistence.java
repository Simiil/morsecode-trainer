package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.UUID;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;

/**
 * API for the persistence layer
 * 
 * @author Samuel Leisering
 *
 */
public interface IPersistence {

    /**
     * register a new challenge
     * 
     * @param user
     *            user
     * @param id
     *            the challenge id
     * @param c
     *            the solution of the challenge
     * @throws NoSuchUserException
     */
    void registerNewChallenge(String user, UUID id, String c) throws NoSuchUserException;

    /**
     * get a challenge
     * 
     * @param user
     *            the user
     * @param id
     *            the id
     * @return the solution of the challenge
     * @throws NoSuchUserException
     * @throws NoSuchChallengeException
     */
    String getChallenge(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException;

    /**
     * get and remove a challenge
     * 
     * @param user
     *            the user
     * @param id
     *            the id of the challenge
     * @return the solution of the challenge
     * @throws NoSuchUserException
     * @throws NoSuchChallengeException
     */
    String removeChallenge(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException;

}