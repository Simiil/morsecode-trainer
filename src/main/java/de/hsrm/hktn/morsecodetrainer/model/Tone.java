package de.hsrm.hktn.morsecodetrainer.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tone {
	public List<Boolean> tone;
	 
	public Tone(Boolean... tones ){
		tone = new ArrayList<>();
		for (Boolean boolean1 : tones) {
			tone.add(boolean1);
		}
	}
	public Tone(List<Boolean> tones){
		this.tone = tones;
	}
}
