package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;
import de.hsrm.hktn.morsecodetrainer.model.persist.PersistedToneChallenge;

public class JPAPersistenceRegistry implements IPersistence {

	private EntityManagerFactory emf;

	public JPAPersistenceRegistry(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void registerNewChallenge(String user, UUID id, Character c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		PersistedToneChallenge ptc = new PersistedToneChallenge();
		ptc.id = id;
		ptc.tone = c;
		em.persist(ptc);
		transaction.commit();
	}

	@Override
	public boolean checkAndRemoveChallenge(String user, UUID id, Character test)
			throws NoSuchUserException, NoSuchChallengeException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			PersistedToneChallenge find = em.find(PersistedToneChallenge.class, id);
			if (find == null) {
				throw new NoSuchChallengeException(user, id);
			}
			em.remove(find);
			return Objects.equals(find.tone, test);
		} finally {
			transaction.commit();
		}
	}
}
