package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.HashMap;
import java.util.Random;

import de.hsrm.hktn.morsecodetrainer.model.protocol.EncodedTone;

public class Util {
	public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static HashMap<Character, EncodedTone> tones = new HashMap<>();

	private static final Boolean s = false;
	private static final Boolean l = true;

	static{
		tones.put('A', new EncodedTone(s,l));
		tones.put('B', new EncodedTone(l,s,s,s));
		tones.put('C', new EncodedTone(l,s,l,s));
		tones.put('D', new EncodedTone(l,s,s));
		tones.put('E', new EncodedTone(s));
		tones.put('F', new EncodedTone(s,s,l,s));
		tones.put('G', new EncodedTone(l,l,s));
		tones.put('H', new EncodedTone(s,s,s,s));
		tones.put('I', new EncodedTone(s,s));
		tones.put('J', new EncodedTone(s,l,l,l));
		tones.put('K', new EncodedTone(l,s,l));
		tones.put('L', new EncodedTone(s,l,s,s));
		tones.put('M', new EncodedTone(l,l));
		tones.put('N', new EncodedTone(l,s));
		tones.put('O', new EncodedTone(l,l,l));
		tones.put('P', new EncodedTone(s,l,l,s));
		tones.put('Q', new EncodedTone(l,l,s,l));
		tones.put('R', new EncodedTone(s,l,s));
		tones.put('S', new EncodedTone(s,s,s));
		tones.put('T', new EncodedTone(l));
		tones.put('U', new EncodedTone(s,s,l));
		tones.put('V', new EncodedTone(s,s,s,l));
		tones.put('W', new EncodedTone(s,l,l));
		tones.put('X', new EncodedTone(l,s,s,l));
		tones.put('Y', new EncodedTone(l,s,l,l));
		tones.put('Z', new EncodedTone(l,l,s,s));
		tones.put('1', new EncodedTone(s,l,l,l,l));
		tones.put('2', new EncodedTone(s,s,l,l,l));
		tones.put('3', new EncodedTone(s,s,s,l,l));
		tones.put('4', new EncodedTone(s,s,s,s,l));
		tones.put('5', new EncodedTone(s,s,s,s,s));
		tones.put('6', new EncodedTone(l,s,s,s,s));
		tones.put('7', new EncodedTone(l,l,s,s,s));
		tones.put('8', new EncodedTone(l,l,l,s,s));
		tones.put('9', new EncodedTone(l,l,l,l,s));
		tones.put('0', new EncodedTone(l,l,l,l,l));
	}
	public static Character random(){
		Random r = new Random();
		int next = r.nextInt(ALPHABET.length());

		return ALPHABET.charAt(next);
	}

	public static EncodedTone mapToTone(Character c){
		return tones.get(c);
	}

}
