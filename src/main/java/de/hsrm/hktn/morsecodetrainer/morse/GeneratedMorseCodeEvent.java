package de.hsrm.hktn.morsecodetrainer.morse;

import de.hsrm.hktn.morsecodetrainer.model.protocol.ToneChallenge;

/**
 * A MorseCode Event. A challenge an its solution
 * 
 * @author Samuel Leisering
 *
 */
public class GeneratedMorseCodeEvent {
    private final ToneChallenge challenge;
    private final String solution;

    /**
     * create a new event
     * 
     * @param challenge
     *            the challenge
     * @param solution
     *            the solution
     */
    public GeneratedMorseCodeEvent(ToneChallenge challenge, Character solution) {
        this(challenge, solution.toString());
    }

    /**
     * create a new event
     * 
     * @param challenge
     *            the challenge
     * @param solution
     *            the solution
     */
    public GeneratedMorseCodeEvent(ToneChallenge challenge, String solution) {
        this.challenge = challenge;
        this.solution = solution;
    }

    public ToneChallenge getChallenge() {
        return challenge;
    }

    public String getSolution() {
        return solution;
    }

}
