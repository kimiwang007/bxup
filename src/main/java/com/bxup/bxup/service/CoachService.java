package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.controller.client.dto.CoachDto;
import com.bxup.bxup.model.Coach;
import com.bxup.bxup.model.CoachPhoto;

public interface CoachService {
	
	String insertCoachInfo(Coach coachInfoForm);
	String insertCoachPhoto(CoachPhoto coachPhotoForm);
	List<CoachDto> findAll() throws SQLException;
}
