package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.ResourceController;
import com.bxup.bxup.model.Event;
import com.bxup.bxup.service.ResourceService;


@Service
public class ResourceServiceImpl implements ResourceService {
	LoginDao dao = null;

	@Override
	public List<Event> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());
		dao = new LoginDao();
		List<Event> resource = LoginDao.SelectAllEvent();	
		//List<EventInsertForm> resource2 = LoginDao.SelectAllEvent();
		log.info("selectAllEventSuccess");
			return resource;
		}

	@Override
	public Event findById(String id) throws SQLException {
       	Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		Event editevent = LoginDao.SelectEventById(id);	
		log.info("SelectEventByIdSuccess");
			return editevent;
	}
	
	
	@Override
	public Event deleteEventById(String id) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		 boolean deleteevent = dao.DeleteEventById(id);
		 log.info("DeleteEventByIdSuccess");
			return null;
	}

	@Override
	public Event updateEventById(Event eventInsertForm) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		 boolean updateevent = dao.UpdateEventById(eventInsertForm);
		 log.info("UpdateEventById");
			return null;
	}
	
	@Override
	public Event updateImg4(Event eventInsertForm) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		 boolean updateimg4 = dao.UpdateImg4(eventInsertForm);
		 log.info("updateImg4");
			return null;
	}
	
	@Override
	public Event updateImg5(Event eventInsertForm) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		 boolean updateimg5 = dao.UpdateImg5(eventInsertForm);
		 log.info("updateImg5");
			return null;
	}
	
	@Override
	public Event updateImg6(Event eventInsertForm) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		 boolean updateimg6 = dao.UpdateImg6(eventInsertForm);
		 log.info("updateImg6");
			return null;
	}
	
	@Override
	public Event updateImg6p(Event eventInsertForm) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		 boolean updateimg6p = dao.UpdateImg6p(eventInsertForm);
		 log.info("updateImg6p");
			return null;
	}
	
	@Override
	public boolean updateshelves(Event eventUpdateForm) throws SQLException{
		Logger log = Logger.getLogger(ResourceController.class.getName());		
		dao = new LoginDao();
		boolean reval = dao.Updateshelves("updateshelves", eventUpdateForm);
		log.info("updateshelves");
		return reval;
	}
}
