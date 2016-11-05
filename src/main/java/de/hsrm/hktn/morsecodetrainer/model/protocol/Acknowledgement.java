package de.hsrm.hktn.morsecodetrainer.model.protocol;

/**
 * An Acknowledgement. Used to respond to a challenge response to indicate the
 * correctness of an answer
 * 
 * @author Samuel Leisering
 *
 */
public class Acknowledgement {
    private final boolean content;

    /**
     * Create an {@link Acknowledgement}
     * 
     * @param content
     *            the content
     */
    public Acknowledgement(boolean content) {
        this.content = content;
    }

    public boolean isContent() {
        return content;
    }

}
