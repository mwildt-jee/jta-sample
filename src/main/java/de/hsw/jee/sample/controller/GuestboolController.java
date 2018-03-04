package de.hsw.jee.sample.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.jee.sample.model.GuestbookEntry;
import de.hsw.jee.sample.service.GuestbookService;

@WebServlet("/")
public class GuestboolController extends HttpServlet{

	@Inject private GuestbookService guestbookService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final List<GuestbookEntry> entries = guestbookService.findAll().stream()
				.sorted(Comparator.comparing(GuestbookEntry::getCreated, Comparator.naturalOrder()).reversed())
				.collect(Collectors.toList());
		
		req.setAttribute("entries", entries);		
		
		req.getRequestDispatcher("/WEB-INF/template/guestbook.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		guestbookService.create(
			req.getParameter("author")
			,req.getParameter("message")
		);
		
		this.doGet(req, resp);
	}
	
}

