package de.hsrm.hktn.morsecodetrainer.model;

import java.util.ArrayList;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ToneChallenge {
	
	public Tone character;
	public UUID id;

	public ToneChallenge(Tone tone, UUID id) {
		this.id = id;
		this.character = tone;
	}
	
	public static ToneChallenge random(){
		ArrayList<Boolean> tone = new ArrayList<>();
		tone.add(true);
		tone.add(false);
		tone.add(true);
		tone.add(true);
		return new ToneChallenge(new Tone(tone), UUID.randomUUID());
	}
}


