package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.controller.client.dto.CoachDto;
import com.bxup.bxup.model.Coach;
import com.bxup.bxup.model.CoachPhoto;
import com.bxup.bxup.model.Subscribe;

public interface CoachService {
	
	String insertCoachInfo(Coach coachInfoForm);
	String insertCoachPhoto(CoachPhoto coachPhotoForm);
	List<CoachDto> findAll() throws SQLException;
	List<CoachDto> findCoachById(String id) throws SQLException;
	String updateCoachById(Coach coachInfoForm) throws SQLException;
	String updateCoachPhotoById(CoachPhoto coachPhotoForm) throws SQLException;
	String deleteCoachById(Coach coachInfoForm) throws SQLException;
	String deleteCoachPhotoById(CoachPhoto coachPhotoForm) throws SQLException;
}
