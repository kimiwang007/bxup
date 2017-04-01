package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.model.Subscribe;
import com.bxup.bxup.model.WelcomeIMG;

public interface WelcomeImgService {
	
	List<WelcomeIMG> findAll() throws SQLException;
	String insertWelcomePhoto(WelcomeIMG welcomePhoto);
	String updateWelcomePhoto(WelcomeIMG welcomePhoto);
	boolean updateshelves(WelcomeIMG welcomePhoto) throws SQLException;
}
