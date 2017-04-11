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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bxup.bxup.common.constant.CommonConstant;
import com.bxup.bxup.model.Subscribe;
import com.bxup.bxup.service.SubscribeService;

@Controller
@RequestMapping(value = "/headline")
public class HeadlineController {
static Logger log = Logger.getLogger(HeadlineController.class.getName());
	
	@Autowired
	private SubscribeService subscribeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllknownchoosehead(Map<String, Object> mode) throws Exception{
		log.info("showAllknown called");
		List<Subscribe> subscribe = subscribeService.findAllKnown();
		List<Subscribe> headline = new ArrayList<Subscribe>();
			
		for(int i=0;i<subscribe.size();i++){		
			if(subscribe.get(i).getSubscribe_type() == 1){
				headline.add(subscribe.get(i));
				mode.put("headline", headline);
			} else if (subscribe.get(i).getSubscribe_type() == null){
				return "failure";
			}	
		}

		return "headline";
	}
	
	@RequestMapping(value = "/headline_shelves/{id}", method = RequestMethod.GET)
	public String setShelves(Model model, @PathVariable int id) throws SQLException {
		log.info("knownsetShelves called");
		Subscribe subUpdateForm = new Subscribe();
		subUpdateForm.setId(id);
		subUpdateForm.setSubscribe_type(0);
		boolean reval = subscribeService.updateshelves(subUpdateForm);
		if(reval){
			log.info("knownsetShelves end");
		} else {
			log.info("knownsetShelves failure");
			return CommonConstant.FORWARD_FAILURE;
		}
		return "redirect:/headline";
	}
	
	@RequestMapping(value = "headline_edit/{id}", method = RequestMethod.GET)
	public String editHeadline(@PathVariable String id, Model model) throws Exception {
		
		log.info("editHeadline called");
		Subscribe subscribe = subscribeService.findKnownById(id);

		model.addAttribute("id", subscribe.getId());
		model.addAttribute("tab", subscribe.getTab());
		model.addAttribute("title", subscribe.getTitle());
		model.addAttribute("feedimgurl", subscribe.getFeedImgUrl());
		model.addAttribute("feedimg", subscribe.getFeedImg());
		model.addAttribute("url", subscribe.getUrl());
		model.addAttribute("summary", subscribe.getSummary());
		model.addAttribute("publish_time", subscribe.getPublish_time());
		model.addAttribute("subscribe_type", subscribe.getSubscribe_type());
		model.addAttribute("status", subscribe.getDeleteStatus());

		return "editheadline";
	}
	
	
	@RequestMapping(value = "/headline_delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id, Map<String, Object> model) throws Exception {

		log.info("delete called");
		subscribeService.deleteKnownById(id);

		return "redirect:/headline";
	}

	@RequestMapping(value = "/headline_update/{id}", method = RequestMethod.POST)
	public String updateevent(@PathVariable String id, HttpServletRequest request, HttpServletResponse response,
			Subscribe subscribe) throws SQLException {
		log.info("updateHeadline called");

		Date d = new Date();
		subscribe.setPublish_time(d);
		
		subscribeService.updateKnownById(subscribe);

		return "redirect:/headline";
	}
	
	
}


