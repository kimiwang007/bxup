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
@RequestMapping(value = "/known")
public class KnownController {
	static Logger log = Logger.getLogger(KnownController.class.getName());

	@Autowired
	private SubscribeService subscribeService;

	@RequestMapping(method = RequestMethod.GET)
	public String showAllknownchoosehead(Map<String, Object> mode) throws Exception {
		log.info("showAllknown called");
		List<Subscribe> subscribe = subscribeService.findAllKnown();
		List<Subscribe> known = new ArrayList<Subscribe>();

		for (int i = 0; i < subscribe.size(); i++) {
			// String picture_url = properties.getProperty("picture_url");
			if (subscribe.get(i).getSubscribe_type() == 2) {
				known.add(subscribe.get(i));
				mode.put("known", known);
			}
		}

		return "known";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String feedSet(@PathVariable String id, Map<String, Object> mode) throws Exception {
		String[] idList = id.split("'");
		List<Subscribe> known = new ArrayList<Subscribe>();

		for (int i = 1; i < idList.length; i++) {
			List<Subscribe> subscribe = subscribeService.selectSubscribeForID(Long.valueOf(idList[i]));
			if (subscribe.size() > 0) {
				known.add(subscribe.get(0));
			}
		}

		mode.put("items", known);
		mode.put("setType", "known");

		return "feedSet";
	}

	@RequestMapping(value = "/feedImgSave", method = RequestMethod.POST)
	public String feedImgSave(@ModelAttribute FeedImgSave feedImgData, Map<String, Object> mode) throws Exception {
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
		subscribe.setSubscribe_type(2);
		boolean reval = subscribeService.UpdateFeedImgToNullByType(subscribe);
		if (!reval) {
			return "failure";
		}
		
		//new feedImg set
		String picturepositiontmp = properties.getProperty("picturepositiontmp");

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
				String path = picturepositiontmp + filenamesave.toString();
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
			
			subscribe.setSubscribe_type(2);
			reval = subscribeService.UpdateFeedImgByid(subscribe);
			if (!reval) {
				return "failure";
			}
		}
		
		return "redirect:/known";
	}
}
