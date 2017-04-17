package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.controller.client.dto.CoachDto;
import com.bxup.bxup.controller.client.dto.GymDto;
import com.bxup.bxup.model.Gym;
import com.bxup.bxup.model.GymPhoto;

public interface GymService {
	
	String insertGymInfo(Gym gymInfoForm);
	String insertGymPhoto(GymPhoto gymPhotoForm);
	List<GymDto> findAll() throws SQLException;
	List<Gym> findAllGymName() throws SQLException;
	List<GymDto> findGymById(String id) throws SQLException;
	Object findgymById(int gymid);
	boolean updateshelves(Gym gymUpdateForm) throws SQLException;
}
