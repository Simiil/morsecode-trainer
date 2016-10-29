package de.hsrm.hktn.morsecodetrainer.model.persist;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ChallengeId.class)
public class PersistedToneChallenge {
	@Id
	public UUID id;

	public char tone;

	@Id
	public User user;
}
