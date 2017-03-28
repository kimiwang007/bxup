package com.bxup.bxup.constroller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bxup.bxup.common.constant.CommonConstant;
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
import com.bxup.bxup.service.CoachService;
import com.bxup.bxup.service.EventInsertService;
import com.bxup.bxup.service.FeedBackService;
import com.bxup.bxup.service.GymService;
import com.bxup.bxup.service.ShowService;
import com.bxup.bxup.service.SubscribeService;
import com.bxup.bxup.service.UserService;
import com.bxup.bxup.service.WelcomeImgService;

@Controller
public class RestController {

	static Logger log = Logger.getLogger(RestController.class.getName());

	@Autowired(required = false)
	private EventInsertService eventInsertService;
	// 20170303 Baojun Add
	@Autowired(required = false)
	private CoachService coachInfoService;
	// 20170304 Baojun Add
	@Autowired(required = false)
	private GymService gymInfoService;
	// 20170304 Baojun Add
	@Autowired(required = false)
	private FeedBackService feedBackService;
	// 20170314 Baojun Add
	@Autowired(required = false)
	private UserService userService;
	// 20170314 Baojun Add
	@Autowired(required = false)
	private ShowService showService;
	// 20170319 Baojun Add
	@Autowired(required = false)
	private SubscribeService subscribeService;
	@Autowired
	private WelcomeImgService welcomeImgService;

	@RequestMapping(value = "/eventAdd", method = RequestMethod.GET)
	public String eventAdd() {
		log.info("WelcomePage called");

		return "eventAdd";
	}

	// 20170303 Baojun ADD
	@RequestMapping(value = "/coachInfoAdd", method = RequestMethod.GET)
	public String coachInfoAdd(Map<String, Object> mode) throws SQLException {
		log.info("coachInfoAdd called");

//		List<Gym> gym = gymInfoService.findAll();
//		/*
//		 * List<String> gymnamelist = new ArrayList<String>();
//		 * 
//		 * for(int i=0;i<gym.size();i++){
//		 * 
//		 * gymnamelist.add(gym.get(i).getName()); }
//		 */
//		mode.put("coachInfoAdd", gym);

		return "coachInfoAdd";
	}

	// 20170304 Baojun ADD
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String feedback(Map<String, Object> mode) throws SQLException {
		log.info("feedback called");
		List<FeedBack> feedback = feedBackService.findAll();
		User user = new User();

		for (int i = 0; i < feedback.size(); i++) {

			int userid = feedback.get(i).getUser_id();
			if (userid != 0) {
				user = feedBackService.findnikenameById(userid);
				feedback.get(i).setNikename(user.getNickname());
			}
		}
		mode.put("feedback", feedback);

		return "feedback";
	}

	// 20170315 Baojun ADD
	@RequestMapping(value = "/userInfoAdd", method = RequestMethod.GET)
	public String userInfoAdd() {
		log.info("userInfoAdd called");

		return "userInfoAdd";
	}

	// 20170315 Baojun ADD
	@RequestMapping(value = "/showInfoAdd", method = RequestMethod.GET)
	public String showInfoAdd(Map<String, Object> mode) throws SQLException {
		log.info("showInfoAdd called");

		List<User> user = userService.findPhoneyAll();
		mode.put("showInfoAdd", user);
		return "showInfoAdd";
	}

	// 20170319 Baojun ADD
	@RequestMapping(value = "/subscribeAdd", method = RequestMethod.GET)
	public String subscribeAdd(Map<String, Object> mode) throws SQLException {
		log.info("subscribeAdd called");

		return "subscribeInfoAdd";
	}

	// 20170327 Baojun ADD
	@RequestMapping(value = "/changeWelcomePhoto", method = RequestMethod.GET)
	public String changeWelcomePhoto(Map<String, Object> mode) throws SQLException {
		log.info("changeWelcomePhoto called");

		return "changeWelcomePhoto";
	}

	@RequestMapping(value = "/eventAdd", method = RequestMethod.POST)
	public String eventAdd(Model model, HttpServletRequest request, HttpServletResponse response,
			Event eventInsertForm) {
		log.info("eventAdd called");
		model.addAttribute("event_name", eventInsertForm.getEvent_name());
		model.addAttribute("event_start_date", eventInsertForm.getEvent_start_date());
		model.addAttribute("event_end_date", eventInsertForm.getEvent_end_date());
		model.addAttribute("event_time", eventInsertForm.getEvent_time());
		model.addAttribute("event_link", eventInsertForm.getEvent_link());
		model.addAttribute("event_desc", eventInsertForm.getEvent_desc());
		model.addAttribute("event_place", eventInsertForm.getEvent_place());
		model.addAttribute("img_Type", eventInsertForm.getImg_Type());
		model.addAttribute("endDate", eventInsertForm.getEndDate());
		model.addAttribute("startDate", eventInsertForm.getStartDate());
		model.addAttribute("tab", eventInsertForm.getTab());

		return "eventAdd";
	}

	@RequestMapping(value = "/comfirmeventAdd", method = RequestMethod.POST)
	public String comfirmeventAdd(Model model, HttpServletRequest request, HttpServletResponse response,
			Event eventInsertForm) throws IllegalStateException, IOException {
		log.info("comfirmeventAdd called");
		model.addAttribute("event_name", eventInsertForm.getEventName());
		model.addAttribute("tab", eventInsertForm.getTab());
		model.addAttribute("event_start_date", eventInsertForm.getEventStartDate());
		model.addAttribute("event_end_date", eventInsertForm.getEventEndDate());
		model.addAttribute("event_time", eventInsertForm.getEventTime());
		model.addAttribute("event_link", eventInsertForm.getEventLink());
		model.addAttribute("event_desc", eventInsertForm.getEventDesc());
		model.addAttribute("event_place", eventInsertForm.getEventPlace());
		model.addAttribute("img_Type", eventInsertForm.getImg_Type());
		model.addAttribute("endDate", eventInsertForm.getEndDate());
		model.addAttribute("startDate", eventInsertForm.getStartDate());

		String iphoneimgtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

		HashMap<String, String> filename = new HashMap<String, String>();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("picturepositiontmp");
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<?> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				StringBuilder filenamesave = new StringBuilder();
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				String picturename = file.getOriginalFilename();
				int position = picturename.indexOf(CommonConstant.POINT);
				if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
					filenamesave.append(file.getName());
					filenamesave.append(CommonConstant.UNDERLINE);
					filenamesave.append(picturename.substring(0, position));
					filenamesave.append(iphoneimgtime);
					filenamesave.append(picturename.substring(position));
					//
					filename.put(file.getName(), filenamesave.toString());
					String path = picturepositiontmp + filenamesave.toString();
					file.transferTo(new File(path));
				}
			}
		}
		model.addAttribute("iPhone4IMGName", filename.get(CommonConstant.IPHONE4IMGNAME));
		model.addAttribute("iPhone5IMGName", filename.get(CommonConstant.IPHONE5IMGNAME));
		model.addAttribute("iPhone6IMGName", filename.get(CommonConstant.IPHONE6IMGNAME));
		model.addAttribute("iPhone6PIMGName", filename.get(CommonConstant.IPHONE6PIMGNAME));
		model.addAttribute("event_def", filename.get(CommonConstant.EVENTDEFNAME));
		model.addAttribute("fri_def", filename.get(CommonConstant.FRIENDDEFNAME));
		model.addAttribute("pk_def", filename.get(CommonConstant.PKDEFNAME));
		model.addAttribute("metal_def", filename.get(CommonConstant.METALDEFNAME));

		if (CommonConstant.ONE.equals(eventInsertForm.getImg_Type())
				|| CommonConstant.TWO.equals(eventInsertForm.getImg_Type())) {
			return "comfirmevent";
		} else if (CommonConstant.THREE.equals(eventInsertForm.getImg_Type())) {
			return "comfirmeventtwo";
		}
		return CommonConstant.FORWARD_FAILURE;

	}

	@RequestMapping(value = "/maineventAdd", method = RequestMethod.POST)
	public String maineventAdd(HttpServletRequest request, HttpServletResponse response, Event eventInsertForm)
			throws Exception {
		log.info("maineventAdd called");
		String mainflg = new String();

		String sucflg = eventInsertService.insertEvent(eventInsertForm);
		List<String> decfileList = new ArrayList<String>();
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String pictureposition = properties.getProperty("pictureposition");
		String picturepositiontmp = properties.getProperty("picturepositiontmp");
		if (eventInsertForm.getiPhone4IMGName() != null) {
			decfileList.add(eventInsertForm.getiPhone4IMGName());
		}
		if (eventInsertForm.getiPhone5IMGName() != null) {
			decfileList.add(eventInsertForm.getiPhone5IMGName());
		}
		if (eventInsertForm.getiPhone6IMGName() != null) {
			decfileList.add(eventInsertForm.getiPhone6IMGName());
		}
		if (eventInsertForm.getiPhone6PIMGName() != null) {
			decfileList.add(eventInsertForm.getiPhone6PIMGName());
		}
		if (eventInsertForm.getEventDef() != null) {
			decfileList.add(eventInsertForm.getEventDef());
		}
		if (eventInsertForm.getFriendDef() != null) {
			decfileList.add(eventInsertForm.getFriendDef());
		}
		if (eventInsertForm.getpKDef() != null) {
			decfileList.add(eventInsertForm.getpKDef());
		}
		if (eventInsertForm.getMetalDef() != null) {
			decfileList.add(eventInsertForm.getMetalDef());
		}

		if (CommonConstant.ONE.equals(eventInsertForm.getImg_Type())
				|| CommonConstant.TWO.equals(eventInsertForm.getImg_Type())) {
			if (sucflg.equals(CommonConstant.FORWARD_FAILURE)) {
				for (int i = 0; i < decfileList.size(); i++) {
					File file = new File(pictureposition + decfileList.get(i));
					file.delete();
				}
				mainflg = CommonConstant.FORWARD_FAILURE;
			} else {
				for (int i = 0; i < decfileList.size(); i++) {
					File file = new File(picturepositiontmp + decfileList.get(i));
					file.renameTo(new File(pictureposition + file.getName()));
					file.delete();
				}
				log.info("InsertForm1 ended");
				mainflg = CommonConstant.FORWARD_SUCCESS;
			}
		} else if (CommonConstant.THREE.equals(eventInsertForm.getImg_Type())) {
			if (sucflg.equals(CommonConstant.FORWARD_FAILURE)) {
				for (int i = 0; i < decfileList.size(); i++) {
					File file = new File(pictureposition + decfileList.get(i));
					file.delete();
				}
				mainflg = CommonConstant.FORWARD_FAILURE;
			} else {
				for (int i = 0; i < decfileList.size(); i++) {
					File file = new File(picturepositiontmp + decfileList.get(i));
					file.renameTo(new File(pictureposition + decfileList.get(i)));
					file.delete();
				}
				log.info("InsertForm2 ended");
				mainflg = CommonConstant.FORWARD_SUCCESS;
			}

		}
		return mainflg;
	}

	// 20170325 Baojun ADD
	@RequestMapping(value = "/loginpictureAdd", method = RequestMethod.POST)
	public String loginpictureAdd(Model model, HttpServletRequest request, HttpServletResponse response, Event event)
			throws IllegalStateException, IOException {

		log.info("loginpictureAdd called");

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("coachpictureposition");
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<?> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				String picturename = file.getOriginalFilename();
				if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
					event.setIphone5_img(picturename);
					String path = picturepositiontmp + picturename;
					file.transferTo(new File(path));
				}
			}
		}
		String sucflg = eventInsertService.insertEvent(event);

		if (sucflg.equals(CommonConstant.FORWARD_SUCCESS)) {
			log.info("loginpictureAdd success!");
			return "redirect:/resources";
		} else {
			return CommonConstant.FORWARD_FAILURE;
		}
	}

	// 20170303 Baojun ADD
	@RequestMapping(value = "/maincoachInfoAdd", method = RequestMethod.POST)
	public String maincoachInfoAdd(Model model, HttpServletRequest request, HttpServletResponse response,
			Coach coachInfoForm) throws IllegalStateException, IOException {

		CoachPhoto cachPhotoForm = new CoachPhoto();
		log.info("maincoachInfoAdd called");

		Date d = new Date();
		Long create_time = d.getTime();
		coachInfoForm.setCreate_time(create_time);

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("coachpictureposition");
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<?> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				String picturename = file.getOriginalFilename();
				coachInfoForm.setAvatar(picturename);
				cachPhotoForm.setPhoto(picturename);
				if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
					String path = picturepositiontmp + picturename;
					file.transferTo(new File(path));
				}
			}
		}
		String sucflg = coachInfoService.insertCoachInfo(coachInfoForm);
		String ucfflg = coachInfoService.insertCoachPhoto(cachPhotoForm);
		if (sucflg.equals(CommonConstant.FORWARD_SUCCESS) && ucfflg.equals(CommonConstant.FORWARD_SUCCESS)) {
			log.info("insertCoachInfo and insertCoachPhoto success!");
			return "redirect:/coach";
		} else {
			return CommonConstant.FORWARD_FAILURE;
		}
	}
	// 20170314 Baojun Add
	@RequestMapping(value = "/userAdd", method = RequestMethod.POST)
	public String userAdd(Model model, HttpServletRequest request, HttpServletResponse response, User user)
			throws IllegalStateException, IOException {

		Date d = new Date();
		Long create_time = d.getTime();
		user.setCreate_time(create_time);
		user.setPlatform_id("999999999");

		String sucflg = userService.insertUserInfo(user);
		if (sucflg.equals(CommonConstant.FORWARD_SUCCESS)) {
			log.info("insertUserInfo  success!");
			return "redirect:/user";
		} else {
			return CommonConstant.FORWARD_FAILURE;
		}
	}

	// 20170315 Baojun Add
	@RequestMapping(value = "/showAdd", method = RequestMethod.POST)
	public String showAdd(Model model, HttpServletRequest request, HttpServletResponse response, Show showForm)
			throws IllegalStateException, IOException, SQLException {
		log.info("showAdd called");
		Photo photoForm = new Photo();
		ShowPhotoRel showPhotoRelForm = new ShowPhotoRel();
		Date d = new Date();
		Long create_time = d.getTime();
		showForm.setCreate_time(create_time);
		photoForm.setCreate_time(create_time);

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("gympictureposition");
		List<String> filenameList = new ArrayList<String>();

		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<?> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				String picturename = file.getOriginalFilename();
				filenameList.add(picturename);
				if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
					String path = picturepositiontmp + picturename;
					file.transferTo(new File(path));
				}
			}
		}
		long user_id = showForm.getUser_id();
		showService.insertShow(showForm);
		showForm.getId();

		String relflg = null;

		showPhotoRelForm.setShow_id(showForm.getId());
		for (int i = 0; i < filenameList.size(); i++) {
			photoForm.setFile_name(filenameList.get(i));
			photoForm.setCreate_user_id(user_id);
			if (filenameList.get(i) != "") {
				showService.insertPhoto(photoForm);
				photoForm.getId();
				showPhotoRelForm.setPhoto_id(photoForm.getId());
				relflg = showService.insertPhotoshowrel(showPhotoRelForm);
			}
		}

		if (relflg.equals(CommonConstant.FORWARD_SUCCESS)) {
			log.info("insertShow success!");
			return "redirect:/show";
		} else {
			return CommonConstant.FORWARD_FAILURE;
		}
	}

	// 20170319 Baojun Add
	@RequestMapping(value = "/subscribeInfoAdd", method = RequestMethod.POST)
	public String subscribeInfoAdd(Model model, HttpServletRequest request, HttpServletResponse response,
			Subscribe subscribeForm) throws IllegalStateException, IOException {

		Date d = new Date();
		subscribeForm.setPublish_time(d);
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("gympictureposition");
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<?> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {

				MultipartFile file = multiRequest.getFile(iter.next().toString());
				String picturename = file.getOriginalFilename();
				subscribeForm.setImg(picturename);
				if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
					String path = picturepositiontmp + picturename;
					file.transferTo(new File(path));
				}
			}
		}
		String sucflg = subscribeService.insertSubscribeInfo(subscribeForm);
		if (sucflg.equals(CommonConstant.FORWARD_SUCCESS) && subscribeForm.getSubscribe_type() == 0) {
			log.info("insertSubscribeInfo Success!");
			return "redirect:/headline";
		} else if (sucflg.equals(CommonConstant.FORWARD_SUCCESS) && subscribeForm.getSubscribe_type() == 2) {
			log.info("insertSubscribeInfo Success!");
			return "redirect:/known";
		} else if (sucflg.equals(CommonConstant.FORWARD_SUCCESS) && subscribeForm.getSubscribe_type() == 3) {
			log.info("insertSubscribeInfo Success!");
			return "redirect:/choose";
		} else {
			return CommonConstant.FORWARD_FAILURE;
		}
	}

	@RequestMapping(value = "/welcomePhotoAdd", method = RequestMethod.GET)
	public String WelcomePhotoAdd( HttpServletRequest request, HttpServletResponse response,
			WelcomeIMG welcomePhoto) throws IllegalStateException, IOException {/*
		log.info("welcomePhotoAdd called");
		String suuflg = welcomeImgService.updateWelcomePhoto(welcomePhoto);
		Date d = new Date();
		Long create_date = d.getTime();
		// welcomePhoto.setCreate_date(create_date);
		HashMap<String, String> filename = new HashMap<String, String>();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("gympictureposition");
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<?> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				StringBuilder filenamesave = new StringBuilder();
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				String picturename = file.getOriginalFilename();
				int position = picturename.indexOf(CommonConstant.POINT);
				if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
					filenamesave.append(file.getName());
					filenamesave.append(CommonConstant.UNDERLINE);
					filenamesave.append(picturename.substring(0, position));
					filenamesave.append(picturename.substring(position));
					//
					filename.put(file.getName(), filenamesave.toString());
					String path = picturepositiontmp + filenamesave.toString();
					try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// welcomePhoto.setIphone4_img(filename.get(CommonConstant.IPHONE4IMGNAME));
				// welcomePhoto.setIphone5_img(filename.get(CommonConstant.IPHONE5IMGNAME));
				// welcomePhoto.setIphone6_img(filename.get(CommonConstant.IPHONE6IMGNAME));
				// welcomePhoto.setIphone6p_img(filename.get(CommonConstant.IPHONE6PIMGNAME));
				// welcomePhoto.setIphone7_img(filename.get(CommonConstant.IPHONE6PIMGNAME));
				// welcomePhoto.setIphone7p_img(filename.get(CommonConstant.IPHONE6PIMGNAME));
			}
		}

		String sucflg = welcomeImgService.insertWelcomePhoto(welcomePhoto);
		if (sucflg.equals(CommonConstant.FORWARD_SUCCESS)) {
			log.info("changeWelcomePhoto success!");
			return "redirect:/welcomeimg";
		} else {
			return CommonConstant.FORWARD_FAILURE;
		}
	*/
	return CommonConstant.FORWARD_FAILURE;
   }
	
	
}
