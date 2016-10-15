package de.hsrm.hktn.morsecodetrainer;

public class NoSuchUserException extends Exception {
	public NoSuchUserException(String user) {
		super(user);
	}
}
