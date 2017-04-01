package com.bxup.bxup.access;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bxup.bxup.common.constant.CommonConstant;
import com.bxup.bxup.common.constant.ImgtypeEnum;
import com.bxup.bxup.constroller.RestController;
import com.bxup.bxup.controller.client.dto.CoachDto;
import com.bxup.bxup.controller.client.dto.GymDto;
import com.bxup.bxup.controller.client.dto.ShowDto;
import com.bxup.bxup.model.Coach;
import com.bxup.bxup.model.CoachPhoto;
import com.bxup.bxup.model.Event;
import com.bxup.bxup.model.FeedBack;
import com.bxup.bxup.model.Gym;
import com.bxup.bxup.model.GymPhoto;
import com.bxup.bxup.model.Photo;
import com.bxup.bxup.model.Show;
import com.bxup.bxup.model.ShowPhotoRel;
import com.bxup.bxup.model.Subscribe;
import com.bxup.bxup.model.User;
import com.bxup.bxup.model.WelcomeIMG;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LoginDao {
	static Logger log = Logger.getLogger(RestController.class.getName());
	private static final SqlMapClient sqlMap;
	static {
		log.info("SqlMapClientBuilder Start.");

		try {
			String resource = "SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			log.info("SqlMapClientBuilder End.");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			throw new RuntimeException("Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}

	public static String AddT_event(Event eventInsertForm, int imgtype) {
		log.info("SqlAddT_event Start.");
		String sucflg = null;
		Event eventAdd = new Event();
		if (ImgtypeEnum.STRING_EVENT.getStringValue().equals(Integer.toString(imgtype))
				|| ImgtypeEnum.STRING_BANNER.getStringValue().equals(Integer.toString(imgtype))) {
			eventAdd.setEventName(eventInsertForm.getEventName());
			eventAdd.setTab(eventInsertForm.getTab());
			eventAdd.setEventDesc(eventInsertForm.getEventDesc());
			eventAdd.setEventPlace(eventInsertForm.getEventPlace());
			eventAdd.setImgtype(imgtype);
			eventAdd.setiPhone4IMGName(eventInsertForm.getiPhone4IMGName());
			eventAdd.setiPhone6IMGName(eventInsertForm.getiPhone6IMGName());
			eventAdd.setiPhone6PIMGName(eventInsertForm.getiPhone6PIMGName());
			eventAdd.setAndroidIMGName1(eventInsertForm.getAndroidIMGName1());
			eventAdd.setAndroidIMGName2(eventInsertForm.getAndroidIMGName2());
			eventAdd.setAndroidIMGName3(eventInsertForm.getAndroidIMGName3());
			eventAdd.setEventStartDate(eventInsertForm.getEventStartDate());
			eventAdd.setEventEndDate(eventInsertForm.getEventEndDate());
			eventAdd.setEventLink(eventInsertForm.getEventLink());
			eventAdd.setEventTime(eventInsertForm.getEventTime());
			eventAdd.setCreateDate(eventInsertForm.getCreateDate());
			eventAdd.setCreateID(eventInsertForm.getCreateID());
			eventAdd.setDel_fg(eventInsertForm.getDel_fg());
			try {
				sqlMap.insert("insertEventInsertForm1", eventAdd);
			} catch (SQLException e) {

				e.printStackTrace();
				log.error(e.getMessage());
				sucflg = CommonConstant.FORWARD_FAILURE;
				return sucflg;
			}
			sucflg = CommonConstant.FORWARD_SUCCESS;
			return sucflg;
		} else if (ImgtypeEnum.STRING_ICON.getStringValue().equals(Integer.toString(imgtype))) {
			eventAdd.setEventDef(eventInsertForm.getEventDef());
			eventAdd.setFriendDef(eventInsertForm.getFriendDef());
			eventAdd.setpKDef(eventInsertForm.getpKDef());
			eventAdd.setMetalDef(eventInsertForm.getMetalDef());
			eventAdd.setStartDate(eventInsertForm.getStartDate());
			eventAdd.setEndDate(eventInsertForm.getEndDate());
			eventAdd.setCreateDate(eventInsertForm.getCreateDate());
			eventAdd.setCreateID(eventInsertForm.getCreateID());
			try {
				sqlMap.insert("insertEventInsertForm2", eventAdd);

			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e.getMessage());
				sucflg = CommonConstant.FORWARD_FAILURE;
				return sucflg;
			}
			sucflg = CommonConstant.FORWARD_SUCCESS;
			return sucflg;
		} else if (ImgtypeEnum.STRING_LOGINPICTURE.getStringValue().equals(Integer.toString(imgtype))) {

			eventAdd.setiPhone5IMGName(eventInsertForm.getiPhone5IMGName());
			eventAdd.setImgtype(imgtype);
			try {
				sqlMap.insert("insertLoginpicture", eventAdd);

			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e.getMessage());
				sucflg = CommonConstant.FORWARD_FAILURE;
				return sucflg;
			}
			sucflg = CommonConstant.FORWARD_SUCCESS;
			return sucflg;
		}
		log.info("SqlAddT_event End.");
		return sucflg;

	}

	public static List<Event> SelectAllEvent() throws SQLException {
		log.info("SqlSelectAllEvent Start.");
		List<Event> eventInsertForm = null;
		String sucflg = null;
		try {
			eventInsertForm = sqlMap.queryForList("selectAllEvent", eventInsertForm);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SqlselectAllEvent End.");
		return eventInsertForm;
	}

	public static Event SelectEventById(String id) throws SQLException {
		log.info("SqlSelectEventById Start.");
		Event eventInsertForm = null;
		String sucflg = null;
		try {
			eventInsertForm = (Event) sqlMap.queryForObject("selectEventById", id);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;
		log.info("SqlselectEventById End.");
		return eventInsertForm;
	}

	public boolean DeleteEventById(String id) throws SQLException {
		log.info("SqlDeleteEventById Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		Event eventInsertForm = new Event();
		eventInsertForm.setId(id);
		try {
			object = sqlMap.update("deleteEventById", eventInsertForm);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("sqldeleteEventById End.");
			flag = true;
		}
		return flag;

	}

	public boolean UpdateEventById(Event eventInsertForm) throws SQLException {
		log.info("SqlUpdateEventById Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		try {
			object = sqlMap.update("updateEventById", eventInsertForm);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("sqlUpdateEventById End.");
			flag = true;
		}
		return flag;
	}

	public boolean UpdateImg4(Event eventInsertForm) throws SQLException {
		log.info("SqlUpdateEventById Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		try {
			object = sqlMap.update("updateimg4", eventInsertForm);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("sqlUpdateEventById End.");
			flag = true;
		}
		return flag;
	}

	public boolean UpdateImg5(Event eventInsertForm) throws SQLException {
		log.info("SqlUpdateEventById Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		try {
			object = sqlMap.update("updateimg5", eventInsertForm);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("sqlUpdateEventById End.");
			flag = true;
		}
		return flag;
	}

	public boolean UpdateImg6(Event eventInsertForm) throws SQLException {
		log.info("SqlUpdateEventById Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		try {
			object = sqlMap.update("updateimg6", eventInsertForm);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("sqlUpdateEventById End.");
			flag = true;
		}
		return flag;
	}

	public boolean UpdateImg6p(Event eventInsertForm) throws SQLException {
		log.info("SqlUpdateEventById Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		try {
			object = sqlMap.update("updateimg6p", eventInsertForm);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("sqlUpdateEventById End.");
			flag = true;
		}
		return flag;
	}

	public boolean Updateshelves(String sql,Object eventUpdateForm) throws SQLException {
		log.info("Updateshelves Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		try {
			object = sqlMap.update(sql, eventUpdateForm);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("Updateshelves End.");
			flag = true;
		}
		return flag;
	}
	
	// 20170303 Baojun ADD
	public static String AddT_coach(Coach coachInfoForm) {
		log.info("SqlAddT_coach Start.");
		String sucflg = null;
		Object generatedKey = null;
		try {
			generatedKey = sqlMap.insert("insertCoachInfoForm", coachInfoForm);
		} catch (SQLException e) {

			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg = generatedKey.toString();
		return sucflg;
	}

	// 20170304 Baojun Add
	public static String AddT_coach_photo_rel(CoachPhoto coachPhotoForm) {
		log.info("SqlAddT_coach_photo_rel Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertCoachPhotoForm", coachPhotoForm);
		} catch (SQLException e) {

			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;
		return sucflg;
	}

	// 20170304 Baojun ADD
	public static String AddT_gym(Gym gymInfoForm) {
		log.info("SqlAddT_gym Start.");
		String sucflg = null;
		Object generatedKey = null;
		try {
			generatedKey = sqlMap.insert("insertGymInfoForm", gymInfoForm);
		} catch (SQLException e) {

			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg = generatedKey.toString();
		return sucflg;
	}
		
	// 20170304 Baojun Add
	public static String AddT_gym_photo_rel(GymPhoto gymPhotoForm) {
		log.info("SqlAddT_coach_photo_rel Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertGymPhotoForm", gymPhotoForm);
		} catch (SQLException e) {

			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;
		return sucflg;
	}

	// 20170304 Baojun Add
	public static List<FeedBack> SelectAllFeedBack() throws SQLException {
		log.info("SqlSelectAllEvent Start.");
		List<FeedBack> feedBackForm = null;
		String sucflg = null;
		try {
			feedBackForm = sqlMap.queryForList("selectAllFeedBack", feedBackForm);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SqlselectAllEvent End.");
		return feedBackForm;
	}

	// 20170308 Baojun Add
	public static List<GymDto> SelectAllGym() throws SQLException {
		log.info("SqlSelectAllEvent Start.");
		List<GymDto> gym = null;
		String sucflg = null;
		try {
			gym = sqlMap.queryForList("selectAllGym", gym);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SqlselectAllGym End.");
		return gym;
	}

	// 20170328 wwb Add
	public static List<Gym> SelectAllGymName() throws SQLException {
		log.info("SqlSelectAllEvent Start.");
		List<Gym> gym = null;
		String sucflg = null;
		try {
			gym = sqlMap.queryForList("selectAllGymName", gym);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SqlselectAllGym End.");
		return gym;
	}

	// 20170308 Baojun Add
	public static List<CoachDto> SelectAllCoach() throws SQLException {
		log.info("SqlSelectAllEvent Start.");
		List<CoachDto> coach = null;
		String sucflg = null;
		try {
			coach = sqlMap.queryForList("selectAllCoach", coach);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SqlselectAllCoach End.");
		return coach;
	}

	// 20170311 Baojun Add
	public static Object SelectAllGymnameById(int gymid) {
		log.info("SqlSelectAllEvent Start.");
		String sucflg = null;
		Object gym = null;
		try {
			gym = sqlMap.queryForObject("selectAllGymnameById", gymid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SqlselectAllGym End.");
		return gym;
	}

	// 20170314 Baojun Add
	public static List<User> SelectAllUser() throws SQLException {
		log.info("SqlSelectAllUser Start.");
		List<User> user = null;
		String sucflg = null;
		try {
			user = sqlMap.queryForList("selectAllUser", user);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SqlselectAllUser End.");
		return user;
	}

	// 20170314 Baojun Add
	public static List<User> SelectPhoneyUser() throws SQLException {
		log.info("SQLSelectPhoneyUser Start.");
		List<User> user = null;
		String sucflg = null;
		try {
			user = sqlMap.queryForList("selectPhoneyUser", user);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SQLSelectPhoneyUser End.");
		return user;
	}

	// 20170314 Baojun ADD
	public static String AddT_user(User userForm) {
		log.info("SqlAddT_user Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertUserForm", userForm);
		} catch (SQLException e) {

			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;
		return sucflg;
	}

	// 20170315 Baojun Add
	public static List<ShowDto> SelectAllShow() throws SQLException {
		log.info("SqlSelectAllShow Start.");
		List<ShowDto> showDto = null;
		String sucflg = null;
		try {
			showDto = sqlMap.queryForList("selectAllShow", showDto);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SqlselectAllShow End.");
		return showDto;
	}

	// 20170315 Baojun ADD
	public static String AddT_show(Show showForm) {
		log.info("SqlAddT_show Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertShowForm", showForm);
		} catch (SQLException e) {

			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;
		return sucflg;
	}

	// 20170315 Baojun ADD
	public static String AddT_photo(Photo photoForm) {
		log.info("SqlAddT_show Start.");
		String sucflg = null;

		try {
			sqlMap.insert("insertPhotoForm", photoForm);
		} catch (SQLException e) {

			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;
		return sucflg;
	}

	// 20170315 Baojun ADD
	public static String AddT_showphotorel(ShowPhotoRel showPhotoRelForm) {
		log.info("SqlAddT_show Start.");
		String sucflg = null;
		try {
			sqlMap.insert("insertshowPhotorelForm", showPhotoRelForm);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			return sucflg;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;
		return sucflg;
	}

	// 20170316 Baojun Add
	public static List<Photo> FindT_photoid(long user_id) {
		log.info("FindT_photobyid Start.");
		String sucflg = null;
		List<Photo> photo = null;
		try {
			photo = sqlMap.queryForList("selectphotobyid", user_id);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("FindT_photobyid End.");
		return photo;
	}

	// 20170316 Baojun Add
	public static List<Show> FindT_showid(long user_id) {
		log.info("FindT_photobyid Start.");
		String sucflg = null;
		List<Show> show = null;
		try {
			show = sqlMap.queryForList("selectshowbyid", user_id);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("FindT_photobyid End.");
		return show;
	}

	// 20170318 Baojun Add
	public static User SelectNicknameByid(long user_id) {
		log.info("FindT_photobyid Start.");
		String sucflg = null;
		User user = new User();
		try {
			user = (User) sqlMap.queryForObject("selectnikenameById", user_id);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("selectnickbyid End.");
		return user;
	}

	// 20170318 Baojun Add
	public static List<ShowPhotoRel> FindT_showphotorel(long id) {
		log.info("FindShowPhotoRel Start.");
		String sucflg = null;
		List<ShowPhotoRel> rel = null;
		try {
			rel = sqlMap.queryForList("selectrelbyid", id);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("selectShowPhotoRel End.");
		return rel;
	}

	public static List<Photo> FindT_photonamebyid(long photo_id) {
		log.info("Findphotonamebyid Start.");
		String sucflg = null;
		List<Photo> photo = null;
		try {
			photo = sqlMap.queryForList("selectphotonamebyid", photo_id);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("selectphotonamebyid End.");
		return photo;
	}

	public static List<Subscribe> SelectAllsubscribe() {
		log.info("Findsubscribe Start.");
		String sucflg = null;
		List<Subscribe> subscribe = null;
		try {
			subscribe = sqlMap.queryForList("SelectAllsubscribe", subscribe);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("selectsubscribe End.");
		return subscribe;
	}

	public static String insertSubscribeInfo(Subscribe subscribeForm) {
		log.info("insertSubscribeInfo Start.");
		String sucflg = null;
		try {
			sqlMap.insert("insertSubscribeInfo", subscribeForm);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("insertSubscribeInfo End.");
		return sucflg;
	}

	public boolean DeleteShowById(long id) throws SQLException {
		log.info("SqlDeleteEventById Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		Show show = new Show();
		show.setId(id);
		try {
			object = sqlMap.update("deleteShowById", show);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("sqldeleteEventById End.");
			flag = true;
		}
		return flag;

	}

	public boolean UpdateFeedImgToNullByType(Subscribe subscribe) throws SQLException {
		log.info("UpdateFeedImgToNullByType Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		try {
			object = sqlMap.update("updateFeedImgToNullByType", subscribe);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("UpdateFeedImgToNullByType End.");
			flag = true;
		}
		return flag;
	}

	public boolean UpdateFeedImgByid(Subscribe subscribe) throws SQLException {
		log.info("UpdateFeedImgByid Start.");
		boolean flag = false;
		Object object = false;
		String sucflg = null;
		try {
			object = sqlMap.update("updateFeedImgByid", subscribe);
		} catch (SQLException e) {
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		if (object != null) {
			sucflg = CommonConstant.FORWARD_SUCCESS;
			log.info("UpdateFeedImgByid End.");
			flag = true;
		}
		return flag;
	}

	// 20170325 wwb Add
	public static List<Subscribe> SelectSubscribeForID(long id) {
		log.info("Find T_subscribe Start.");
		String sucflg = null;
		List<Subscribe> subscribe = null;
		try {
			subscribe = sqlMap.queryForList("SelectSubscribeForID", id);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("selectnickbyid End.");
		return subscribe;
	}

	// 20170327 Baojun Add
	public static List<WelcomeIMG> SelectAllWelcomePhoto() throws SQLException {
		log.info("SelectAllWelcomePhoto Start.");
		List<WelcomeIMG> welcomePhoto = null;
		String sucflg = null;
		try {
			welcomePhoto = sqlMap.queryForList("selectAllWelcomePhoto", welcomePhoto);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;
			throw e;
		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("SelectAllWelcomePhoto End.");
		return welcomePhoto;
	}

	// 20170327 Baojun Add
	public static String AddT_welcomePhoto(WelcomeIMG welcomePhoto) {
		log.info("insertWelcomePhoto Start.");
		String sucflg = null;
		try {
			sqlMap.insert("insertWelcomePhoto", welcomePhoto);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("insertWelcomePhoto End.");
		return sucflg;
	}

	// 20170327 Baojun Add
	public static String updateT_welcomePhoto(WelcomeIMG welcomePhoto) {
		log.info("insertWelcomePhoto Start.");
		String sucflg = null;
		try {
			sqlMap.update("updateWelcomePhoto", welcomePhoto);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			sucflg = CommonConstant.FORWARD_FAILURE;

		}
		sucflg = CommonConstant.FORWARD_SUCCESS;

		log.info("insertWelcomePhoto End.");
		return sucflg;
	}

}
