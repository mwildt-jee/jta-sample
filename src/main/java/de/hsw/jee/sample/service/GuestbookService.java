
package de.hsw.jee.sample.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import de.hsw.jee.sample.model.GuestbookEntry;
import de.hsw.jee.sample.repository.GuestbookRepository;

@ApplicationScoped
public class GuestbookService {

	@Inject @Default
	private GuestbookRepository guestbookRepository;

	public List<GuestbookEntry> findAll() {
		return guestbookRepository.findAll();
	}

	public void create(final String author, final String message) {
		final GuestbookEntry entry = new GuestbookEntry();
		
		entry.setAuthor(author);
		entry.setMessage(message);
		
		guestbookRepository.save(entry);
	}
		
	
}
