package de.hsw.jee.sample.model;

import java.util.Date;

public class GuestbookEntry {

	private Long id;
	
	private String message;
	
	private String author;
	
	private Date created;

	public void prePersist() {
		this.created = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
