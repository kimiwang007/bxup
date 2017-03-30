package com.bxup.bxup.constroller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
		for(int i=0;i<subscribe.size();i++){
			if(subscribe.get(i).getSubscribe_type() == 3){
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
}


