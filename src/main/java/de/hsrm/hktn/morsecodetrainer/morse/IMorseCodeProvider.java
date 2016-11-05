package de.hsrm.hktn.morsecodetrainer.morse;

/**
 * A Provider that creates challenges
 * 
 * @author Samuel Leisering
 *
 */
public interface IMorseCodeProvider {
    /**
     * create a new challenge for the given user
     * 
     * @param user
     *            the user
     * @return the generated challenge
     */
    GeneratedMorseCodeEvent createChallengeForUser(String user);

}
