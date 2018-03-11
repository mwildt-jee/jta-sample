package de.hsw.jee.sample.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import de.hsw.jee.sample.model.GuestbookEntry;

@Transactional
@ApplicationScoped 
@Default
public class JPAGuestbookRepository implements GuestbookRepository {

	@PersistenceContext(unitName="sample")
	private EntityManager entityManager;
	
	public List<GuestbookEntry> findAll() {
		return entityManager.createQuery("select e from GuestbookEntry e", GuestbookEntry.class).getResultList();
	}
	
	public Optional<GuestbookEntry> findById(final Long id) {
		TypedQuery<GuestbookEntry> query = entityManager.createQuery("select e from GuestbookEntry e where id = :id", GuestbookEntry.class);
		query.setParameter("id", id);
		try {
			return Optional.of(query.getSingleResult());
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	public GuestbookEntry save(GuestbookEntry entry) {		
		entityManager.persist(entry);
		return entry;
	}

}
