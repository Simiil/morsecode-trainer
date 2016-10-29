package de.hsrm.hktn.morsecodetrainer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "TONE_ENC")
public class EncodedTone {
	@Id
	@GeneratedValue
	long id;

	public List<Boolean> tone;

	public EncodedTone() {
		// JPA Constructor
	}

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
