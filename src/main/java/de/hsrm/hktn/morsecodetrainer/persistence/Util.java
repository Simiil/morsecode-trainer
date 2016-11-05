package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.HashMap;
import java.util.Random;

import de.hsrm.hktn.morsecodetrainer.model.protocol.EncodedTone;

/**
 * Utils
 * 
 * @author Samuel Leisering
 *
 */
public final class Util {
    private Util() {
        // hide constructor
    }

    /**
     * the alphabet
     */
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static HashMap<Character, EncodedTone> tones = new HashMap<>();

    private static final Boolean S = false;
    private static final Boolean L = true;

    static {
        tones.put('A', new EncodedTone(S, L));
        tones.put('B', new EncodedTone(L, S, S, S));
        tones.put('C', new EncodedTone(L, S, L, S));
        tones.put('D', new EncodedTone(L, S, S));
        tones.put('E', new EncodedTone(S));
        tones.put('F', new EncodedTone(S, S, L, S));
        tones.put('G', new EncodedTone(L, L, S));
        tones.put('H', new EncodedTone(S, S, S, S));
        tones.put('I', new EncodedTone(S, S));
        tones.put('J', new EncodedTone(S, L, L, L));
        tones.put('K', new EncodedTone(L, S, L));
        tones.put('L', new EncodedTone(S, L, S, S));
        tones.put('M', new EncodedTone(L, L));
        tones.put('N', new EncodedTone(L, S));
        tones.put('O', new EncodedTone(L, L, L));
        tones.put('P', new EncodedTone(S, L, L, S));
        tones.put('Q', new EncodedTone(L, L, S, L));
        tones.put('R', new EncodedTone(S, L, S));
        tones.put('S', new EncodedTone(S, S, S));
        tones.put('T', new EncodedTone(L));
        tones.put('U', new EncodedTone(S, S, L));
        tones.put('V', new EncodedTone(S, S, S, L));
        tones.put('W', new EncodedTone(S, L, L));
        tones.put('X', new EncodedTone(L, S, S, L));
        tones.put('Y', new EncodedTone(L, S, L, L));
        tones.put('Z', new EncodedTone(L, L, S, S));
        tones.put('1', new EncodedTone(S, L, L, L, L));
        tones.put('2', new EncodedTone(S, S, L, L, L));
        tones.put('3', new EncodedTone(S, S, S, L, L));
        tones.put('4', new EncodedTone(S, S, S, S, L));
        tones.put('5', new EncodedTone(S, S, S, S, S));
        tones.put('6', new EncodedTone(L, S, S, S, S));
        tones.put('7', new EncodedTone(L, L, S, S, S));
        tones.put('8', new EncodedTone(L, L, L, S, S));
        tones.put('9', new EncodedTone(L, L, L, L, S));
        tones.put('0', new EncodedTone(L, L, L, L, L));
    }

    /**
     * returns a random character
     * 
     * @return a random {@link Character}
     */
    public static Character random() {
        Random r = new Random();
        int next = r.nextInt(ALPHABET.length());

        return ALPHABET.charAt(next);
    }

    /**
     * encodes a character to morsecode
     * 
     * @param c
     *            the {@link Character}
     * @return the {@link EncodedTone}
     */
    public static EncodedTone mapToTone(Character c) {
        return tones.get(c);
    }

}
