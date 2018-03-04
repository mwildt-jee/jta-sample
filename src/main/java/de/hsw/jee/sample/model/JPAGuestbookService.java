
package de.hsw.jee.sample.model;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class JPAGuestbookService implements GuestbookService {

	/*
	 *  TODO: Der entityManager muss irgendwie erzeugt werden
	 */
	private EntityManager entityManager;
	
	@Override
	public List<GuestbookEntry> findAll() {
		return this.entityManager
			.createQuery("select e from GuestbookEntry e", GuestbookEntry.class)
			.getResultList();
	}

	@Override
	public Optional<GuestbookEntry> findById(Long id) {
		TypedQuery<GuestbookEntry> query = this.entityManager
				.createQuery("select e from GuestbookEntry e where id = :id", GuestbookEntry.class);		
		query.setParameter("id", id);
		try {
			return Optional.of(query.getSingleResult());
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public GuestbookEntry save(GuestbookEntry entry) {
		this.entityManager.persist(entry);
		return entry;
	}

	
	
}
