package com.bxup.bxup.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.constroller.ResourceController;
import com.bxup.bxup.model.Subscribe;
import com.bxup.bxup.service.SubscribeService;

@Service
public class SubscribeServiceImpl implements SubscribeService {

	LoginDao dao = null;

	@Override
	public List<Subscribe> findAllKnown() throws SQLException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(SubscribeServiceImpl.class.getName());
		dao = new LoginDao();
		List<Subscribe> subscribe = LoginDao.SelectAllsubscribe();
		log.info("selectAllsubscribeSuccess");
		return subscribe;
	}

	@Override
	public List<Subscribe> selectSubscribeForID(long id) throws SQLException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(SubscribeServiceImpl.class.getName());
		dao = new LoginDao();
		List<Subscribe> subscribe = LoginDao.SelectSubscribeForID(id);
		log.info("selectSubscribeForID Success");
		return subscribe;
	}

	@Override
	public String insertSubscribeInfo(Subscribe subscribeForm) {
		String sucflg = LoginDao.insertSubscribeInfo(subscribeForm);
		return sucflg;
	};

	@Override
	public boolean UpdateFeedImgToNullByType(Subscribe subscribe) throws SQLException {
		Logger log = Logger.getLogger(SubscribeServiceImpl.class.getName());
		dao = new LoginDao();
		boolean reval = dao.UpdateFeedImgToNullByType(subscribe);
		log.info("UpdateFeedImgToNullByType");
		return reval;
	}

	@Override
	public boolean UpdateFeedImgByid(Subscribe subscribe) throws SQLException {
		Logger log = Logger.getLogger(SubscribeServiceImpl.class.getName());
		dao = new LoginDao();
		boolean reval = dao.UpdateFeedImgByid(subscribe);
		log.info("UpdateFeedImgByid");
		return reval;
	}

	@Override
	public boolean updateshelves(Subscribe subscribe) throws SQLException {
		Logger log = Logger.getLogger(SubscribeServiceImpl.class.getName());
		dao = new LoginDao();
		boolean reval = dao.Updateshelves("updateSubshelves", subscribe);
		log.info("updateshelves");
		return reval;
	}

	@Override
	public Subscribe findKnownById(String id) throws SQLException {
		Logger log = Logger.getLogger(SubscribeServiceImpl.class.getName());
		dao = new LoginDao();
		Subscribe subscribe = LoginDao.SelectKnownById(id);
		log.info("SelectEventByIdSuccess");
		return subscribe;
	}

	@Override
	public Subscribe updateKnownById(Subscribe subscribe) throws SQLException {
		Logger log = Logger.getLogger(SubscribeServiceImpl.class.getName());
		dao = new LoginDao();
		boolean updateknown = dao.UpdateKnownById(subscribe);
		log.info("UpdateKnownById");
		return null;
	}

	@Override
	public Subscribe deleteKnownById(String id) throws SQLException {
		Logger log = Logger.getLogger(ResourceController.class.getName());
		dao = new LoginDao();
		boolean deleteknown = dao.DeleteKnownById(id);
		log.info("DeleteEventByIdSuccess");
		return null;
	}
}
