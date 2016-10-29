package de.hsrm.hktn.morsecodetrainer.model.persist;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersistedToneChallenge {
	@Id
	public UUID id;
	
	public char tone;
}
