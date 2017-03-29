package com.bxup.bxup.constroller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.bxup.bxup.model.WelcomeIMG;
import com.bxup.bxup.service.WelcomeImgService;

@Controller
@RequestMapping(value = "/welcomeimg")
public class WeclomeImgController {

	static Logger log = Logger.getLogger(WeclomeImgController.class.getName());

	@Autowired
	private WelcomeImgService welcomeImgService;

	@RequestMapping(method = RequestMethod.GET)
	public String showAllWelcomeImg(Map<String, Object> mode) throws Exception {
		log.info("showAllWelcomeImg called");
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picture_url = properties.getProperty("picture_url");

		
		List<WelcomeIMG> welcomeIMG = welcomeImgService.findAll();
		if(welcomeIMG.size() > 0){
			welcomeIMG.get(0).setIphone4url(picture_url + "/" + welcomeIMG.get(0).getIphone4_img());
			welcomeIMG.get(0).setIphone5url(picture_url + "/" + welcomeIMG.get(0).getIphone5_img());
			welcomeIMG.get(0).setIphone6url(picture_url + "/" + welcomeIMG.get(0).getIphone6_img());
			welcomeIMG.get(0).setIphone6purl(picture_url + "/" + welcomeIMG.get(0).getIphone6p_img());
			welcomeIMG.get(0).setIphone7url(picture_url + "/" + welcomeIMG.get(0).getIphone7_img());
			welcomeIMG.get(0).setIphone7purl(picture_url + "/" + welcomeIMG.get(0).getIphone7p_img());
			
			welcomeIMG.get(0).setCreateDate(transferLongToDate("yyyy/MM/dd", welcomeIMG.get(0).getCreate_date()));
		}
		mode.put("welcomePhoto", welcomeIMG);
		return "welcomePhoto";
	}

	@RequestMapping(value = "/changeWelcomePhoto", method = RequestMethod.GET)
	public String changeWelcomePhoto() {
		log.info("changeWelcomePhoto called");

		return "changeWelcomePhoto";
	}

	@RequestMapping(value = "/welcomePhotoAdd", method = RequestMethod.POST)
	public String WelcomePhotoAdd(@ModelAttribute WelcomeIMG welcomePhoto, Map<String, Object> mode)
			throws IllegalStateException, IOException {
		log.info("welcomePhotoAdd called");
		String suuflg = welcomeImgService.updateWelcomePhoto(welcomePhoto);
		// Date d = new Date();
		// Long create_date = d.getTime();
		// // welcomePhoto.setCreate_date(create_date);
		welcomePhoto.setDelete_status(1);
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("gympictureposition");

		String imgtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		StringBuilder filenamesave = new StringBuilder();
		int position = 0;

		// pic1
		MultipartFile file = welcomePhoto.getIphone4();
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
				welcomePhoto.setIphone4_img(filenamesave.toString());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic2
		file = welcomePhoto.getIphone5();
		picturename = file.getOriginalFilename();
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
				welcomePhoto.setIphone5_img(filenamesave.toString());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic3
		file = welcomePhoto.getIphone6();
		picturename = file.getOriginalFilename();
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
				welcomePhoto.setIphone6_img(filenamesave.toString());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic4
		file = welcomePhoto.getIphone6p();
		picturename = file.getOriginalFilename();
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
				welcomePhoto.setIphone6p_img(filenamesave.toString());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic5
		file = welcomePhoto.getIphone7();
		picturename = file.getOriginalFilename();
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
				welcomePhoto.setIphone7_img(filenamesave.toString());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// pic6
		file = welcomePhoto.getIphone7p();
		picturename = file.getOriginalFilename();
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
				welcomePhoto.setIphone7p_img(filenamesave.toString());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Date d = new Date();
		Long create_time = d.getTime();
		welcomePhoto.setCreate_date(create_time);

		// SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		// try {
		// Date startDate= sdf.parse(welcomePhoto.getStart_date());
		// Date endDate= sdf.parse(welcomePhoto.getEnd_date());
		// Date createDate= new Date();
		// welcomePhoto.setStartDate(startDate);
		// welcomePhoto.setEndDate(endDate);
		// welcomePhoto.setCreateDate(createDate);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		String sucflg = welcomeImgService.insertWelcomePhoto(welcomePhoto);
		if (sucflg.equals(CommonConstant.FORWARD_SUCCESS)) {
			log.info("changeWelcomePhoto success!");
			return "redirect:/welcomeimg";
		} else {
			return CommonConstant.FORWARD_FAILURE;
		}

	}

	private String transferLongToDate(String dateFormat, Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = new Date(millSec);
		return sdf.format(date);
	}
}
