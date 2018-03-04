package de.hsw.jee.sample.model;

import java.util.List;
import java.util.Optional;

public interface GuestbookService {

	List<GuestbookEntry> findAll();
	
	Optional<GuestbookEntry> findById(Long id);
	
	GuestbookEntry save(GuestbookEntry entry); 
}
