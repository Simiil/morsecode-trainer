package de.hsrm.hktn.morsecodetrainer.model.protocol;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name = "TONE_ENC")
public class EncodedTone {
	public List<Boolean> tone;

	public EncodedTone(Boolean... tones) {
		tone = new ArrayList<>();
		for (Boolean boolean1 : tones) {
			tone.add(boolean1);
		}
	}

	public EncodedTone(List<Boolean> tones) {
		this.tone = tones;
	}
}
