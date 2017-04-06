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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bxup.bxup.common.constant.CommonConstant;
import com.bxup.bxup.model.FeedImgSave;
import com.bxup.bxup.model.Subscribe;
import com.bxup.bxup.service.SubscribeService;

@Controller
@RequestMapping(value = "/choose")
public class ChooseController {
static Logger log = Logger.getLogger(ChooseController.class.getName());
	
	@Autowired
	private SubscribeService subscribeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllknownchoosehead(Map<String, Object> mode) throws Exception{
		log.info("showAllknown called");
		List<Subscribe> subscribe = subscribeService.findAllKnown();
		List<Subscribe> choose = new ArrayList<Subscribe>();
		
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));

		String picture_url = properties.getProperty("picture_url");
		
		for(int i=0;i<subscribe.size();i++){
			if(subscribe.get(i).getSubscribe_type() == 3){
				if(subscribe.get(i).getImg() != null){
					subscribe.get(i).setImgUrl(picture_url + "/" + subscribe.get(i).getImg());
				}
				if(subscribe.get(i).getFeedImg() != null){
					subscribe.get(i).setFeedImgUrl(picture_url + "/" + subscribe.get(i).getFeedImg());
				}
				choose.add(subscribe.get(i));
				mode.put("choose", choose);
			}
		}
		return "choose";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String feedSet(@PathVariable String id, Map<String, Object> mode) throws Exception {
		log.info("ChooseController feedSet called");
		String[] idList = id.split("'");
		List<Subscribe> choose = new ArrayList<Subscribe>();

		for (int i = 1; i < idList.length; i++) {
			List<Subscribe> subscribe = subscribeService.selectSubscribeForID(Long.valueOf(idList[i]));
			if (subscribe.size() > 0) {
				choose.add(subscribe.get(0));
			}
		}

		mode.put("items", choose);
		mode.put("setType", "choose");

		return "feedSet";
	}

	@RequestMapping(value = "/feedImgSave", method = RequestMethod.POST)
	public String feedImgSave(@ModelAttribute FeedImgSave feedImgData, Map<String, Object> mode) throws Exception {
		log.info("ChooseController feedImgSave called");
		Subscribe subscribe = new Subscribe();
		String imgtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// old feedImg clear
		subscribe.setSubscribe_type(3);
		boolean reval = subscribeService.UpdateFeedImgToNullByType(subscribe);
		if (!reval) {
			return "failure";
		}
		
		//new feedImg set
		String pictureposition = properties.getProperty("feedpictureposition");

		for (int i = 0; i < feedImgData.getItmeID().size(); i++) {
			subscribe = new Subscribe();
			subscribe.setId(feedImgData.getItmeID().get(i));

			MultipartFile file = feedImgData.getFeedpicture().get(i);
			StringBuilder filenamesave = new StringBuilder();
			String picturename = file.getOriginalFilename();
			int position = picturename.indexOf(CommonConstant.POINT);
			if (file != null && file.getOriginalFilename() != CommonConstant.BLANK) {
				filenamesave.append(file.getName());
				filenamesave.append(CommonConstant.UNDERLINE);
				filenamesave.append(picturename.substring(0, position));
				filenamesave.append(imgtime);
				filenamesave.append(picturename.substring(position));
				String path = pictureposition + filenamesave.toString();
				try {
					file.transferTo(new File(path));
					subscribe.setFeedImg(filenamesave.toString());
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			subscribe.setSubscribe_type(3);
			reval = subscribeService.UpdateFeedImgByid(subscribe);
			if (!reval) {
				return "failure";
			}
		}
		
		return "redirect:/choose";
	}
	
	@RequestMapping(value = "/choose_shelves/{id}", method = RequestMethod.GET)
	public String setShelves(Model model, @PathVariable int id) throws SQLException {
		log.info("choosesetShelves called");
		Subscribe subUpdateForm = new Subscribe();
		subUpdateForm.setId(id);
		subUpdateForm.setSubscribe_type(3);
		boolean reval = subscribeService.updateshelves(subUpdateForm);
		if(reval){
			log.info("choosesetShelves end");
		} else {
			log.info("choosesetShelves failure");
			return CommonConstant.FORWARD_FAILURE;
		}
		return "redirect:/choose";
	}
	
	
	@RequestMapping(value = "choose_edit/{id}", method = RequestMethod.GET)
	public String editChoose(@PathVariable String id, Model model) throws Exception {
		
		log.info("editChoose called");
		Subscribe subscribe = subscribeService.findKnownById(id);

		model.addAttribute("id", subscribe.getId());
		model.addAttribute("tab", subscribe.getTab());
		model.addAttribute("title", subscribe.getTitle());
		model.addAttribute("img", subscribe.getImg());
		model.addAttribute("url", subscribe.getUrl());
		model.addAttribute("summary", subscribe.getSummary());
		model.addAttribute("publish_time", subscribe.getPublish_time());
		model.addAttribute("subscribe_type", subscribe.getSubscribe_type());
		model.addAttribute("status", subscribe.getStatus());

		return "editchoose";
	}
	
	
	@RequestMapping(value = "/choose_delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, Map<String, Object> model) throws Exception {

		log.info("delete called");
		subscribeService.deleteKnownById(id);

		return "redirect:/choose";
	}

	@RequestMapping(value = "/choose_update", method = RequestMethod.POST)
	public String updateevent(HttpServletRequest request, HttpServletResponse response,
			Subscribe subscribe) throws SQLException {
		log.info("updateChoose called");

		String imgtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String picturepositiontmp = properties.getProperty("pictureposition");
		
		//pic1
		MultipartFile file = subscribe.getImgfile();
		StringBuilder filenamesave = new StringBuilder();
		int position = 0;		
		String picturename = file.getOriginalFilename();
		position = picturename.indexOf(CommonConstant.POINT);
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
				subscribe.setImg(filenamesave.toString());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Date d = new Date();
		subscribe.setPublish_time(d);
		
		subscribeService.updateKnownById(subscribe);

		return "redirect:/choose";
	}
	
		
}


