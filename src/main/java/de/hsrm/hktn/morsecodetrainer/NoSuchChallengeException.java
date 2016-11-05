package de.hsrm.hktn.morsecodetrainer;

import java.util.UUID;

/**
 * A missing Challenge
 * 
 * @author Samuel Leisering
 *
 */
public class NoSuchChallengeException extends Exception {
    private static final long serialVersionUID = -745880579931371436L;

    /**
     * Create the exception
     * 
     * @param user
     *            the user
     * @param challenge
     *            the non-existent challenge ID
     */
    public NoSuchChallengeException(String user, UUID challenge) {
        super(user + ": " + String.valueOf(challenge));
    }
}
