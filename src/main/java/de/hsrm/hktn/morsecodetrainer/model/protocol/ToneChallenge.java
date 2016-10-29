package de.hsrm.hktn.morsecodetrainer.model.protocol;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ToneChallenge {
	public EncodedTone character;
	
	public UUID id;
	
	public ToneChallenge(EncodedTone tone, UUID id) {
		this.id = id;
		this.character = tone;
	}
	
	public static ToneChallenge random(){
		ArrayList<Boolean> tone = new ArrayList<>();
		tone.add(true);
		tone.add(false);
		tone.add(true);
		tone.add(true);
		return new ToneChallenge(new EncodedTone(tone), UUID.randomUUID());
	}
}


