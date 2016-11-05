package de.hsrm.hktn.morsecodetrainer.model.protocol;

import java.util.ArrayList;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A Simple Challenge
 * 
 * @author Samuel Leisering
 *
 */
@XmlRootElement
public class ToneChallenge {
    private final EncodedTone character;

    private final UUID id;

    /**
     * create a new Challenge
     * 
     * @param tone
     *            the tone
     * @param id
     *            the challenge ID
     */
    public ToneChallenge(EncodedTone tone, UUID id) {
        this.id = id;
        this.character = tone;
    }

    /**
     * Create a mew random challenge
     * 
     * @return the challenge
     */
    public static ToneChallenge random() {
        ArrayList<Boolean> tone = new ArrayList<>();
        tone.add(true);
        tone.add(false);
        tone.add(true);
        tone.add(true);
        return new ToneChallenge(new EncodedTone(tone), UUID.randomUUID());
    }

    public EncodedTone getCharacter() {
        return character;
    }

    public UUID getId() {
        return id;
    }

}
