package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.HashMap;
import java.util.Random;

import de.hsrm.hktn.morsecodetrainer.model.Tone;

public class Util {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz1234567890";
	private static HashMap<Character, Tone> tones = new HashMap<>();
	
	private static final Boolean s = false;
	private static final Boolean l = true;
	
	static{
		tones.put('a', new Tone(s,l));
		tones.put('b', new Tone(l,s,s,s));
		tones.put('c', new Tone(l,s,l,s));
		tones.put('d', new Tone(l,s,s));
		tones.put('e', new Tone(s));
		tones.put('f', new Tone(s,s,l,s));
		tones.put('g',new Tone(l,l,s) );
		tones.put('h', new Tone(s,s,s,s));
		tones.put('i', new Tone(s,s));
		tones.put('j', new Tone(s,l,l,l));
		tones.put('k', new Tone(l,s,l));
		tones.put('l', new Tone(s,l,s,s));
		tones.put('m', new Tone(l,l));
		tones.put('n', new Tone(l,s));
		tones.put('o', new Tone(l,l,l));
		tones.put('p', new Tone(s,l,l,s));
		tones.put('q', new Tone(l,l,s,l));
		tones.put('r', new Tone(s,l,s));
		tones.put('s', new Tone(s,s,s));
		tones.put('t', new Tone(l));
		tones.put('u', new Tone(s,s,l));
		tones.put('v', new Tone(s,s,s,l));
		tones.put('w', new Tone(s,l,l));
		tones.put('x', new Tone(l,s,s,l));
		tones.put('y', new Tone(l,s,l,l));
		tones.put('z', new Tone(l,l,s,s));
		tones.put('1', new Tone(s,l,l,l,l));
		tones.put('2', new Tone(s,s,l,l,l));
		tones.put('3', new Tone(s,s,s,l,l));
		tones.put('4', new Tone(s,s,s,s,l));
		tones.put('5', new Tone(s,s,s,s,s));
		tones.put('6', new Tone(l,s,s,s,s));
		tones.put('7', new Tone(l,l,s,s,s));
		tones.put('8', new Tone(l,l,l,s,s));
		tones.put('9', new Tone(l,l,l,l,s));
		tones.put('0', new Tone(l,l,l,l,l));
		
		
	}
	public static Character random(){
		Random r = new Random();
		int next = r.nextInt(ALPHABET.length());
		
		return ALPHABET.charAt(next);
	}
	
	public static Tone mapToTone(Character c){
		return tones.get(c);
	}
	
}
