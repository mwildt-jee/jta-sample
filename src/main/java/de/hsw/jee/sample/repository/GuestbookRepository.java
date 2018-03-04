package de.hsw.jee.sample.repository;

import java.util.List;
import java.util.Optional;

import de.hsw.jee.sample.model.GuestbookEntry;

public interface GuestbookRepository {

	List<GuestbookEntry> findAll();
	
	Optional<GuestbookEntry> findById(Long id);
	
	GuestbookEntry save(GuestbookEntry entry); 
}
