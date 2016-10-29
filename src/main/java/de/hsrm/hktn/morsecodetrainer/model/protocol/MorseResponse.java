package de.hsrm.hktn.morsecodetrainer.model.protocol;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MorseResponse {
	public String character;
	public String id;
	
	public MorseResponse() {
	}
}
