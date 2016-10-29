package de.hsrm.hktn.morsecodetrainer.model.persist;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	public String username;

	public String mail;

}
