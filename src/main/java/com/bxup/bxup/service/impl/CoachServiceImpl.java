package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.ResourceController;
import com.bxup.bxup.controller.client.dto.CoachDto;
import com.bxup.bxup.model.Coach;
import com.bxup.bxup.model.CoachPhoto;
import com.bxup.bxup.service.CoachService;

@Service
public class CoachServiceImpl implements CoachService {
	LoginDao dao = null;

	@Override
	public List<CoachDto> findAll() throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());
		dao = new LoginDao();
		List<CoachDto> coach = LoginDao.SelectAllCoach();
		log.info("selectAllGymSuccess");
		return coach;
	}

	@Override
	public String insertCoachInfo(Coach coachInfoForm) {
		String sucflg = LoginDao.AddT_coach(coachInfoForm);
		return sucflg;
	};

	@Override
	public String insertCoachPhoto(CoachPhoto coachPhotoForm) {
		String sucflg = LoginDao.AddT_coach_photo_rel(coachPhotoForm);
		return sucflg;
	};

}
