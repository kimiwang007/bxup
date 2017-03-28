package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.ResourceController;
import com.bxup.bxup.controller.client.dto.GymDto;
import com.bxup.bxup.model.Gym;
import com.bxup.bxup.model.GymPhoto;
import com.bxup.bxup.service.GymService;

@Service
public class GymServiceImpl implements GymService {
	LoginDao dao = null;

	@Override
	public List<GymDto> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());
		dao = new LoginDao();
		List<GymDto> gym = LoginDao.SelectAllGym();
		log.info("selectAllGymSuccess");
		return gym;
	}

	@Override
	public List<Gym> findAllGymName() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());
		dao = new LoginDao();
		List<Gym> gym = LoginDao.SelectAllGymName();
		log.info("selectAllGymSuccess");
		return gym;
	}

	@Override
	public String insertGymInfo(Gym gymInfoForm) {
		String sucflg = LoginDao.AddT_gym(gymInfoForm);
		return sucflg;
	}

	@Override
	public String insertGymPhoto(GymPhoto gymPhotoForm) {
		String sucflg = LoginDao.AddT_gym_photo_rel(gymPhotoForm);
		return sucflg;
	}

	// 20170311 Baojun add
	@Override
	public Object findgymById(int gymid) {
		Logger log = Logger.getLogger(ResourceController.class.getName());
		dao = new LoginDao();
		Object gym = LoginDao.SelectAllGymnameById(gymid);
		log.info("selectAllGymSuccess");
		return gym;
	}

}