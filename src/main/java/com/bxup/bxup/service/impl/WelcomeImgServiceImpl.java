package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.WelcomeController;
import com.bxup.bxup.model.User;
import com.bxup.bxup.model.WelcomeIMG;
import com.bxup.bxup.service.WelcomeImgService;

@Service
public class WelcomeImgServiceImpl implements WelcomeImgService{
	
	LoginDao dao = null;
	
	@Override
	public List<WelcomeIMG> findAll() throws SQLException {
		Logger log = Logger.getLogger(WelcomeController.class.getName());					
		dao = new LoginDao();
		List<WelcomeIMG> welcomePhoto = LoginDao.SelectAllWelcomePhoto();	
		log.info("selectAllWelcomePhotoSuccess");
			return welcomePhoto;
	}
	
	@Override
	public String insertWelcomePhoto(WelcomeIMG welcomePhoto){
		Logger log = Logger.getLogger(WelcomeController.class.getName());
		String sucflg = LoginDao.AddT_welcomePhoto(welcomePhoto);	
		log.info("insertWelcomePhotoSuccess");
		return sucflg;		
	};
	
	@Override
	public String updateWelcomePhoto(WelcomeIMG welcomePhoto){
		Logger log = Logger.getLogger(WelcomeController.class.getName());
		String sucflg = LoginDao.updateT_welcomePhoto(welcomePhoto);	
		log.info("updateWelcomePhoto Success");
		return sucflg;		
	};
	
}
