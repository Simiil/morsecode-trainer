package de.hsrm.hktn.morsecodetrainer.model.protocol;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Response to a challenge
 * 
 * @author Samuel Leisering
 *
 */
@XmlRootElement
public class MorseResponse {
    /**
     * The answer
     */
    public String character;
    
    /**
     * The ID of the challenge
     */
    public String id;
}
