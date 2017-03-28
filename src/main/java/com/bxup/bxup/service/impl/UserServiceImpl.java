package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.ResourceController;
import com.bxup.bxup.model.User;
import com.bxup.bxup.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	LoginDao dao = null;
	
	@Override
	public List<User> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<User> user = LoginDao.SelectAllUser();	
		log.info("selectAllUserSuccess");
			return user;
	}
	
	@Override
	public List<User> findPhoneyAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		List<User> user = LoginDao.SelectPhoneyUser();	
		log.info("SelectPhoneyUser Success");
			return user;
	}
		
	@Override
	public String insertUserInfo(User userForm){						
		String sucflg = LoginDao.AddT_user(userForm);						
		return sucflg;		
	};
	
	@Override
	public User findnicknamebyid(long user_id) throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());					
		dao = new LoginDao();
		User user = LoginDao.SelectNicknameByid(user_id);	
		log.info("selectNicknameByidSuccess");
			return user;
	}


}
