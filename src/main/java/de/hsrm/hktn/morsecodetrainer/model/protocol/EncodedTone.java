package de.hsrm.hktn.morsecodetrainer.model.protocol;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An encoded Tone, using booleans:
 * <ul>
 * <li> <code>true</code> for long
 * <li> <code>false</code> for short
 * </ul>
 * @author Samuel Leisering
 *
 */
/**
 * @author Samuel Leisering
 *
 */
@XmlRootElement
@Table(name = "TONE_ENC")
public class EncodedTone {
    private final List<Boolean> tone;

    /**
     * create a new encoded Tone
     * 
     * @param tones
     *            the tones
     */
    public EncodedTone(Boolean... tones) {
        tone = new ArrayList<>();
        for (Boolean boolean1 : tones) {
            tone.add(boolean1);
        }
    }

    /**
     * create a new encoded Tone
     * 
     * @param tones
     *            the tones
     */
    public EncodedTone(List<Boolean> tones) {
        this.tone = tones;
    }

    public List<Boolean> getTone() {
        return tone;
    }

}
