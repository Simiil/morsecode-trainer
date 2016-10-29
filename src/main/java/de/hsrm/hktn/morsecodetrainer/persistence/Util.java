package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.HashMap;
import java.util.Random;

import de.hsrm.hktn.morsecodetrainer.model.EncodedTone;

public class Util {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz1234567890";
	private static HashMap<Character, EncodedTone> tones = new HashMap<>();
	
	private static final Boolean s = false;
	private static final Boolean l = true;
	
	static{
		tones.put('a', new EncodedTone(s,l));
		tones.put('b', new EncodedTone(l,s,s,s));
		tones.put('c', new EncodedTone(l,s,l,s));
		tones.put('d', new EncodedTone(l,s,s));
		tones.put('e', new EncodedTone(s));
		tones.put('f', new EncodedTone(s,s,l,s));
		tones.put('g',new EncodedTone(l,l,s) );
		tones.put('h', new EncodedTone(s,s,s,s));
		tones.put('i', new EncodedTone(s,s));
		tones.put('j', new EncodedTone(s,l,l,l));
		tones.put('k', new EncodedTone(l,s,l));
		tones.put('l', new EncodedTone(s,l,s,s));
		tones.put('m', new EncodedTone(l,l));
		tones.put('n', new EncodedTone(l,s));
		tones.put('o', new EncodedTone(l,l,l));
		tones.put('p', new EncodedTone(s,l,l,s));
		tones.put('q', new EncodedTone(l,l,s,l));
		tones.put('r', new EncodedTone(s,l,s));
		tones.put('s', new EncodedTone(s,s,s));
		tones.put('t', new EncodedTone(l));
		tones.put('u', new EncodedTone(s,s,l));
		tones.put('v', new EncodedTone(s,s,s,l));
		tones.put('w', new EncodedTone(s,l,l));
		tones.put('x', new EncodedTone(l,s,s,l));
		tones.put('y', new EncodedTone(l,s,l,l));
		tones.put('z', new EncodedTone(l,l,s,s));
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
