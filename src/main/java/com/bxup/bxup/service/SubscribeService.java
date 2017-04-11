package com.bxup.bxup.service;

import java.sql.SQLException;
import java.util.List;

import com.bxup.bxup.model.Subscribe;

public interface SubscribeService {

	List<Subscribe> findAllKnown() throws SQLException;

	List<Subscribe> selectSubscribeForID(long id) throws SQLException;

	String insertSubscribeInfo(Subscribe subscribeForm);

	boolean UpdateFeedImgToNullByType(Subscribe subscribe) throws SQLException;

	boolean UpdateFeedImgByid(Subscribe subscribe) throws SQLException;

	boolean updateshelves(Subscribe subscribe) throws SQLException;

	Subscribe findKnownById(String id) throws SQLException;

	Subscribe updateKnownById(Subscribe subscribe) throws SQLException;

	Subscribe deleteKnownById(String id) throws SQLException;

}
