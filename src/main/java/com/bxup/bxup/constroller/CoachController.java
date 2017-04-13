package com.bxup.bxup.constroller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bxup.bxup.common.constant.CommonConstant;
import com.bxup.bxup.controller.client.dto.CoachDto;
import com.bxup.bxup.model.Coach;
import com.bxup.bxup.model.CoachPhoto;
import com.bxup.bxup.model.Gym;
import com.bxup.bxup.service.CoachService;
import com.bxup.bxup.service.GymService;

@Controller
@RequestMapping(value = "/coach")
public class CoachController {

	static Logger log = Logger.getLogger(CoachController.class.getName());

	@Autowired
	private CoachService coachInfoService;

	@Autowired
	private GymService gymInfoService;

	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws Exception {
		log.info("showAllCoachInfo called");

		List<CoachDto> coach = coachInfoService.findAll();

		if (coach == null) {
			return "coach";
		}
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));

		Long coachID = null;
		List<CoachDto> coachs = new ArrayList<CoachDto>();
		CoachDto coachdto = new CoachDto();
		int imgcount = 1;
		String picture_url = properties.getProperty("picture_url");

		for (int i = 0; i < coach.size(); i++) {
			if (!coach.get(i).getId().equals(coachID)) {
				if (i != 0) {
					coachs.add(coachdto);
				}
				coachdto = new CoachDto();
				coachdto = coach.get(i);

				if (coach.get(i).getGendar() == 1) {
					coachdto.setSex("男");
				} else {
					coachdto.setSex("女");
				}
				if (coach.get(i).getApproved() == 1) {
					coachdto.setApprovedfg("通过");
				} else {
					coachdto.setApprovedfg("未通过");
				}

				coachdto.setPictureurl(picture_url + "/" + coach.get(i).getAvatar());

				coachdto.setPictureName1(coach.get(i).getPhoto());
				coachdto.setPicture1(picture_url + "/" + coach.get(i).getPhoto());
				imgcount = 2;
				coachID = coach.get(i).getId();
			} else {
				if (imgcount == 2) {
					coachdto.setPictureName2(coach.get(i).getPhoto());
					coachdto.setPicture2(picture_url + "/" + coach.get(i).getPhoto());
				} else if (imgcount == 3) {
					coachdto.setPictureName3(coach.get(i).getPhoto());
					coachdto.setPicture3(picture_url + "/" + coach.get(i).getPhoto());
				} else if (imgcount == 4) {
					coachdto.setPictureName4(coach.get(i).getPhoto());
					coachdto.setPicture4(picture_url + "/" + coach.get(i).getPhoto());
				} else if (imgcount == 5) {
					coachdto.setPictureName5(coach.get(i).getPhoto());
					coachdto.setPicture5(picture_url + "/" + coach.get(i).getPhoto());
				}
				imgcount++;
			}
		}
		coachs.add(coachdto);

		mode.put("coach", coachs);
		return "coach";
	}

	// 20170303 Baojun ADD
	@RequestMapping(value = "/coachInfo", method = RequestMethod.GET)
	public String coachInfoAdd(Map<String, Object> mode) throws SQLException {
		log.info("coachInfoAdd called");

		List<Gym> gym = gymInfoService.findAllGymName();

		mode.put("gym", gym);

		return "coachInfoAdd";
	}

	// 20170328 wwb ADD
	@RequestMapping(value = "/coachInfoAdd", method = RequestMethod.POST)
	public String maincoachInfoAdd(@ModelAttribute Coach coachInfoForm, Map<String, Object> mode)
			throws IllegalStateException, IOException {

		log.info("coachInfoAdd called");

		List<CoachPhoto> coachPhotos = new ArrayList<CoachPhoto>();
		CoachPhoto coachPhoto = new CoachPhoto();

		Date d = new Date();
		Long create_time = d.getTime();
		coachInfoForm.setCreate_time(create_time);

		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("coachpictureposition");

		StringBuilder filenamesave = new StringBuilder();
		int position = 0;
		String imgtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

		// Avatar
		MultipartFile file = coachInfoForm.getPhoto();
		String picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		filenamesave = new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();

			try {
				file.transferTo(new File(path));
				coachInfoForm.setAvatar(filenamesave.toString());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		coachInfoForm.setDelete_status(1);
		String sucflg = coachInfoService.insertCoachInfo(coachInfoForm);

		int coachID = 0;
		if (sucflg.equals(CommonConstant.FORWARD_FAILURE)) {
			return CommonConstant.FORWARD_FAILURE;
		} else {
			coachID = Integer.valueOf(sucflg);
		}

		// pic1
		file = coachInfoForm.getPicture1();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		coachPhoto = new CoachPhoto();
		filenamesave = new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();

			try {
				file.transferTo(new File(path));
				coachPhoto.setPhoto(filenamesave.toString());
				coachPhoto.setCoach_id(coachID);
				coachPhoto.setDelete_status(1);
				coachPhotos.add(coachPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic2
		file = coachInfoForm.getPicture2();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		coachPhoto = new CoachPhoto();
		filenamesave = new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();

			try {
				file.transferTo(new File(path));
				coachPhoto.setPhoto(filenamesave.toString());
				coachPhoto.setCoach_id(coachID);
				coachPhoto.setDelete_status(1);
				coachPhotos.add(coachPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic3
		file = coachInfoForm.getPicture3();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		coachPhoto = new CoachPhoto();
		filenamesave = new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();

			try {
				file.transferTo(new File(path));
				coachPhoto.setPhoto(filenamesave.toString());
				coachPhoto.setCoach_id(coachID);
				coachPhoto.setDelete_status(1);
				coachPhotos.add(coachPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic4
		file = coachInfoForm.getPicture4();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		coachPhoto = new CoachPhoto();
		filenamesave = new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();

			try {
				file.transferTo(new File(path));
				coachPhoto.setPhoto(filenamesave.toString());
				coachPhoto.setCoach_id(coachID);
				coachPhoto.setDelete_status(1);
				coachPhotos.add(coachPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic5
		file = coachInfoForm.getPicture5();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		coachPhoto = new CoachPhoto();
		filenamesave = new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();

			try {
				file.transferTo(new File(path));
				coachPhoto.setPhoto(filenamesave.toString());
				coachPhoto.setCoach_id(coachID);
				coachPhoto.setDelete_status(1);
				coachPhotos.add(coachPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String ucfflg = null;
		for (CoachPhoto cp : coachPhotos) {
			ucfflg = coachInfoService.insertCoachPhoto(cp);
			if (ucfflg.equals(CommonConstant.FORWARD_FAILURE)) {
				return CommonConstant.FORWARD_FAILURE;
			}
		}

		log.info("insertCoachInfo and insertCoachPhoto success!");
		return "redirect:/coach";
	}
}
