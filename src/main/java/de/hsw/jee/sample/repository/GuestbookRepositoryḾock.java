package de.hsw.jee.sample.repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import de.hsw.jee.sample.model.GuestbookEntry;

@ApplicationScoped
@Mock
public class GuestbookRepositoryḾock implements GuestbookRepository {

	private final List<GuestbookEntry> data = new LinkedList<>();
	private long sequence = 0;
	
	public List<GuestbookEntry> findAll() {
		return Collections.unmodifiableList(data);
	}
	
	public Optional<GuestbookEntry> findById(final Long id) {
		return data.stream()
			.filter(e -> Objects.equals(e.getId(), id))
			.findFirst();
	}
	
	public GuestbookEntry save(GuestbookEntry entry) {
		entry.setId(++sequence);
		entry.prePersist();
		this.data.add(entry);
		return entry;
				
	}
}
