package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.model.User;

public interface UserService {

	List<User> findAll() throws SQLException;
	List<User> findPhoneyAll() throws SQLException;
	String insertUserInfo(User userForm);
	User findnicknamebyid(long user_id) throws SQLException;
	
	
}
