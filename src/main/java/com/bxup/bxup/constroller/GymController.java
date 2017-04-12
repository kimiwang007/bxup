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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bxup.bxup.common.constant.CommonConstant;
import com.bxup.bxup.controller.client.dto.GymDto;
import com.bxup.bxup.model.Gym;
import com.bxup.bxup.model.GymPhoto;
import com.bxup.bxup.service.GymService;



@Controller
@RequestMapping(value = "/gym")
public class GymController {
	
	static Logger log = Logger.getLogger(GymController.class.getName());
	
	@Autowired
	private GymService gymInfoService;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllgym(Map<String, Object> mode) throws Exception{
		log.info("showAllgym called");
		List<GymDto> gym = gymInfoService.findAll();	
		
		List<GymDto> gyms =  new ArrayList<GymDto>();
		GymDto gymdto = new GymDto();
		
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));

		String picture_url = properties.getProperty("picture_url");
		Long gymID = null;
		int imgcount= 1;
		for(int i=0;i<gym.size();i++){
			if(!gym.get(i).getId().equals(gymID)){				
				if(i != 0){
					gyms.add(gymdto);
				}
				gymdto = new GymDto();
				gymdto = gym.get(i);
				if(gym.get(i).getApproved() == 1){
					gymdto.setApprovedfg("通过");
				}else{
					gymdto.setApprovedfg("未通过");
				}
				gymdto.setGympictureName1(gym.get(i).getPhoto());
				gymdto.setGympicture1(picture_url + "/" + gym.get(i).getPhoto());
				imgcount = 2;
				gymID = gym.get(i).getId();
			} else {
				if(imgcount == 2){
					gymdto.setGympictureName2(gym.get(i).getPhoto());
					gymdto.setGympicture2(picture_url + "/" + gym.get(i).getPhoto());
				} else if(imgcount == 3){
					gymdto.setGympictureName3(gym.get(i).getPhoto());
					gymdto.setGympicture3(picture_url + "/" + gym.get(i).getPhoto());
				} else if(imgcount == 4){
					gymdto.setGympictureName4(gym.get(i).getPhoto());
					gymdto.setGympicture4(picture_url + "/" + gym.get(i).getPhoto());
				}  else if(imgcount == 5){
					gymdto.setGympictureName5(gym.get(i).getPhoto());
					gymdto.setGympicture5(picture_url + "/" + gym.get(i).getPhoto());
				} 
				imgcount++;
			}
		}
		gyms.add(gymdto);
 				
		mode.put("gym", gyms);
		return "gym";
	}

	// 20170304 Baojun ADD
	@RequestMapping(value = "/gymInfo", method = RequestMethod.GET)
	public String gymInfoAdd() {
		log.info("gymInfo called");

		return "gymInfoAdd";
	}
		
	// 20170304 Baojun Add
	@RequestMapping(value = "/gymInfoAdd", method = RequestMethod.POST)
	public String maincoachInfoAdd(@ModelAttribute Gym gymInfoForm, Map<String, Object> mode) throws IllegalStateException, IOException {

		log.info("gymInfoAdd called");
		
		List<GymPhoto> gymPhotos = new ArrayList<GymPhoto>();
		GymPhoto gymPhoto = new GymPhoto();
		
		Date d = new Date();
		Long create_time = d.getTime();
		gymInfoForm.setCreate_time(create_time);
		
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		String picturepositiontmp = properties.getProperty("gympictureposition");
		
		StringBuilder filenamesave = new StringBuilder();
		int position = 0;
		String imgtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		
		gymInfoForm.setDelete_status(1);
		String sucflg = gymInfoService.insertGymInfo(gymInfoForm);
		int gymID = 0;
		if(sucflg.equals(CommonConstant.FORWARD_FAILURE)){
			return CommonConstant.FORWARD_FAILURE;
		} else {
			gymID = Integer.valueOf(sucflg);
		}
		
		//pic1
		MultipartFile file = gymInfoForm.getGympicture1();
		String picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		gymPhoto = new GymPhoto();
		filenamesave =  new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK){
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();			
			
			try {
				file.transferTo(new File(path));
				gymPhoto.setPhoto(filenamesave.toString());
				gymPhoto.setGym_id(gymID);
				gymPhoto.setDelete_status(1);
				gymPhotos.add(gymPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		//pic2
		file = gymInfoForm.getGympicture2();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		gymPhoto = new GymPhoto();
		filenamesave =  new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK){
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();			
			
			try {
				file.transferTo(new File(path));
				gymPhoto.setPhoto(filenamesave.toString());
				gymPhoto.setGym_id(gymID);
				gymPhoto.setDelete_status(1);
				gymPhotos.add(gymPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		//pic3
		file = gymInfoForm.getGympicture3();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		gymPhoto = new GymPhoto();
		filenamesave =  new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK){
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();			
			
			try {
				file.transferTo(new File(path));
				gymPhoto.setPhoto(filenamesave.toString());
				gymPhoto.setGym_id(gymID);
				gymPhoto.setDelete_status(1);
				gymPhotos.add(gymPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//pic4
		file = gymInfoForm.getGympicture4();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		gymPhoto = new GymPhoto();
		filenamesave =  new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK){
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();			
			
			try {
				file.transferTo(new File(path));
				gymPhoto.setPhoto(filenamesave.toString());
				gymPhoto.setGym_id(gymID);
				gymPhoto.setDelete_status(1);
				gymPhotos.add(gymPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//pic5
		file = gymInfoForm.getGympicture5();
		picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
		gymPhoto = new GymPhoto();
		filenamesave =  new StringBuilder();
		if (file != null && file.getOriginalFilename() != CommonConstant.BLANK){
			filenamesave.append(file.getName());
			filenamesave.append(CommonConstant.UNDERLINE);
			filenamesave.append(picturename.substring(0, position));
			filenamesave.append(imgtime);
			filenamesave.append(picturename.substring(position));
			String path = picturepositiontmp + filenamesave.toString();			
			
			try {
				file.transferTo(new File(path));
				gymPhoto.setPhoto(filenamesave.toString());
				gymPhoto.setGym_id(gymID);
				gymPhoto.setDelete_status(1);
				gymPhotos.add(gymPhoto);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String ucfflg = null;
		for(GymPhoto gp : gymPhotos){
			 ucfflg = gymInfoService.insertGymPhoto(gp);
			 if (ucfflg.equals(CommonConstant.FORWARD_FAILURE)){
				return CommonConstant.FORWARD_FAILURE;
			 }
		}
		
		return "redirect:/gym";
	}
	
	@RequestMapping(value = "/gym_shelves/{id}", method = RequestMethod.GET)
	public String setShelves(Model model, @PathVariable int id) throws SQLException {
		log.info("gymsetShelves called");
		Gym gymUpdateForm = new Gym();
		gymUpdateForm.setId(id);
		boolean reval = gymInfoService.updateshelves(gymUpdateForm);
		if(reval){
			log.info("gymsetShelves end");
		} else {
			log.info("gymsetShelves failure");
			return CommonConstant.FORWARD_FAILURE;
		}
		return "redirect:/gym";
	}
}
