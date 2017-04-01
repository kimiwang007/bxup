package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.model.Event;

public interface ResourceService {
	
	

	List<Event> findAll() throws SQLException;
	Event findById(String id) throws SQLException;
	Event deleteEventById(String id) throws SQLException;
	Event updateEventById(Event eventInsertForm) throws SQLException;
	Event updateImg4(Event eventInsertForm) throws SQLException;
	Event updateImg5(Event eventInsertForm) throws SQLException;
	Event updateImg6(Event eventInsertForm) throws SQLException;
	Event updateImg6p(Event eventInsertForm) throws SQLException;
	boolean updateshelves(Event eventUpdateForm) throws SQLException;
}
