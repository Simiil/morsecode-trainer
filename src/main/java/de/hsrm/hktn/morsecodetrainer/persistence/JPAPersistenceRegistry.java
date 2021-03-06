package de.hsrm.hktn.morsecodetrainer.persistence;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import de.hsrm.hktn.morsecodetrainer.NoSuchChallengeException;
import de.hsrm.hktn.morsecodetrainer.NoSuchUserException;
import de.hsrm.hktn.morsecodetrainer.model.persist.ChallengeId;
import de.hsrm.hktn.morsecodetrainer.model.persist.PersistedToneChallenge;
import de.hsrm.hktn.morsecodetrainer.model.persist.User;

/**
 * JPA persistence
 * 
 * @author Samuel Leisering
 *
 */
public class JPAPersistenceRegistry implements IPersistence {

    private EntityManagerFactory emf;

    /**
     * Create a new JPA registry
     * 
     * @param emf
     *            the {@link EntityManagerFactory}
     */
    public JPAPersistenceRegistry(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void registerNewChallenge(String user, UUID id, String c) throws NoSuchUserException {
        EntityManager em = emf.createEntityManager();

        User u = em.find(User.class, user);
        if (u == null) {
            throw new NoSuchUserException(user);
        }

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        PersistedToneChallenge ptc = new PersistedToneChallenge();
        ptc.setId(id);
        ptc.setSolution(c);
        ptc.setUser(u);
        em.persist(ptc);
        transaction.commit();
    }

    @Override
    public String getChallenge(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException {
        EntityManager em = emf.createEntityManager();
        return getPersistedChallenge(user, id, em).getSolution();

    }

    private PersistedToneChallenge getPersistedChallenge(String user, UUID id, EntityManager em)
            throws NoSuchChallengeException {
        ChallengeId cid = new ChallengeId();
        cid.setId(id);
        cid.setUser(user);
        PersistedToneChallenge find = em.find(PersistedToneChallenge.class, cid);
        if (find == null) {
            throw new NoSuchChallengeException(user, id);
        }
        return find;
    }

    @Override
    public String removeChallenge(String user, UUID id) throws NoSuchUserException, NoSuchChallengeException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            PersistedToneChallenge ch = getPersistedChallenge(user, id, em);
            em.remove(ch);
            return ch.getSolution();
        } finally {
            t.commit();
        }
    }

    // @Override
    // public boolean checkAndRemoveChallenge(String user, UUID id, Character
    // test)
    // throws NoSuchUserException, NoSuchChallengeException {
    // EntityManager em = emf.createEntityManager();
    // EntityTransaction transaction = em.getTransaction();
    // try {
    // transaction.begin();
    // ChallengeId cid = new ChallengeId();
    // cid.id = id;
    // // User puser = em.find(User.class, user);
    // // if (puser == null) {
    // // throw new NoSuchUserException(user);
    // // }
    // cid.user = user;
    // PersistedToneChallenge find = em.find(PersistedToneChallenge.class, cid);
    // if (find == null) {
    // throw new NoSuchChallengeException(user, id);
    // }
    // em.remove(find);
    // return Objects.equals(find.tone, test);
    // } catch (Throwable e) {
    // e.printStackTrace();
    // throw e;
    // } finally {
    // transaction.commit();
    // }
    // }
}
