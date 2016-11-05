package de.hsrm.hktn.morsecodetrainer;

/**
 * A missing user
 * 
 * @author Samuel Leisering
 *
 */
public class NoSuchUserException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * create the exception
     * 
     * @param user
     *            the nonexistent user
     */
    public NoSuchUserException(String user) {
        super(user);
    }
}
