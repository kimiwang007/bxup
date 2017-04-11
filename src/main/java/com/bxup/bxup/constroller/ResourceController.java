package com.bxup.bxup.constroller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//import javax.validation.Valid;

//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bxup.bxup.common.constant.CommonConstant;
import com.bxup.bxup.model.Event;
import com.bxup.bxup.service.ResourceService;

@Controller
@RequestMapping(value = "/resources")
public class ResourceController {

	static Logger log = Logger.getLogger(ResourceController.class.getName());

	@Autowired
	private ResourceService resourceService;

	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws Exception {
		log.info("showAllResource called");
		List<Event> resources = resourceService.findAll();
		Properties properties = new Properties();
		for (int i = 0; i < resources.size(); i++) {

			String event_time = resources.get(i).getEvent_time();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(event_time.substring(0, 2));
			stringBuilder.append(":");
			stringBuilder.append(event_time.substring(event_time.length() - 2));
			String timem = stringBuilder.toString();
			resources.get(i).setTimem(timem);

		}

		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String picturepositiontmp = properties.getProperty("picturepositiontmp");
		File f = new File(picturepositiontmp);
		if (!f.exists()) {
			log.info("Folder not exists");
			if (!f.mkdir()) {
				mode.put("message", "create Folder " + f.getPath() + " faile");
				log.error("create Folder faile");
				return "resources";
			}
		}
		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			String filename = fs.getName();
			String time = filename.substring(filename.indexOf(".") - 17, filename.indexOf(".") - 9);
			// System.out.print(time);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			// System.out.println(df.format(new Date()));
			String timenow = df.format(new Date()).toString();
			if (time.compareTo(timenow) < 0) {
				fs.delete();
			}
		}

		mode.put("resources", resources);
		return "resources";
	}

	@RequestMapping(value = "/event_edit/{id}", method = RequestMethod.GET)
	public String editEvent(Model model, @PathVariable String id) throws SQLException {
		log.info("editEvent called");
		Event edit_event = resourceService.findById(id);
		/*
		 * Iterator iter = edit_event.iterator(); while(iter.hasNext()){ String
		 * str = (String) iter.next(); System.out.println(str); }
		 */

		model.addAttribute("event_name", edit_event.getEvent_name());
		model.addAttribute("tag", edit_event.getTag());
		model.addAttribute("event_start_date", edit_event.getEvent_start_date());
		model.addAttribute("event_end_date", edit_event.getEvent_end_date());
		model.addAttribute("event_time", edit_event.getEvent_time());
		model.addAttribute("event_link", edit_event.getEvent_link());
		model.addAttribute("event_desc", edit_event.getEvent_desc());
		model.addAttribute("event_place", edit_event.getEvent_place());
		model.addAttribute("id", edit_event.getId());
		model.addAttribute("iphone4_img", edit_event.getIphone4_img());
		model.addAttribute("iphone5_img", edit_event.getIphone5_img());
		model.addAttribute("iphone6_img", edit_event.getIphone6_img());
		model.addAttribute("iphone6p_img", edit_event.getIphone6p_img());

		return "editevent";
	}
	
	@RequestMapping(value = "/event_shelves/{id}", method = RequestMethod.GET)
	public String setShelves(Model model, @PathVariable String id) throws SQLException {
		log.info("setShelves called");
		Event eventUpdateForm = new Event();
		eventUpdateForm.setId(id);
		boolean reval = resourceService.updateshelves(eventUpdateForm);
		if(reval){
			log.info("setShelves end");
		} else {
			log.info("setShelves failure");
			return CommonConstant.FORWARD_FAILURE;
		}
		return "redirect:/resources";
	}

	@RequestMapping(value = "/event_delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, Map<String, Object> model) throws Exception {

		log.info("delete called");
		resourceService.deleteEventById(id);

		return "redirect:/resources";
	}

	@RequestMapping(value = "/event_update/{id}", method = RequestMethod.POST)
	public String updateevent(@PathVariable String id, HttpServletRequest request, HttpServletResponse response,
			Event eventInsertForm) throws SQLException {
		log.info("updateevent called");

		String iphoneimgtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

		HashMap<String, String> filename = new HashMap<String, String>();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("Webinfo.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String picturepositiontmp = properties.getProperty("pictureposition");
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
				eventInsertForm.setiPhone4IMGName(filename.get(CommonConstant.IPHONE4IMGNAME));
				eventInsertForm.setiPhone5IMGName(filename.get(CommonConstant.IPHONE5IMGNAME));
				eventInsertForm.setiPhone6IMGName(filename.get(CommonConstant.IPHONE6IMGNAME));
				eventInsertForm.setiPhone6PIMGName(filename.get(CommonConstant.IPHONE6PIMGNAME));
			}
		}
		if (eventInsertForm.getiPhone4IMGName() != null) {
			resourceService.updateImg4(eventInsertForm);
		} else if (eventInsertForm.getiPhone5IMGName() != null) {
			resourceService.updateImg5(eventInsertForm);
		} else if (eventInsertForm.getiPhone6IMGName() != null) {
			resourceService.updateImg6(eventInsertForm);
		} else if (eventInsertForm.getiPhone6PIMGName() != null) {
			resourceService.updateImg6p(eventInsertForm);
		}
		resourceService.updateEventById(eventInsertForm);

		return "redirect:/resources";
	}

}
