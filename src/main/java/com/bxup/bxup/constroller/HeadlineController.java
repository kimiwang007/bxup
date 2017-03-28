package com.bxup.bxup.constroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			if(subscribe.get(i).getSubscribe_type() == 0){
				headline.add(subscribe.get(i));
				mode.put("headline", headline);
			} else if (subscribe.get(i).getSubscribe_type() == null){
				return "failure";
			}	
		}

		return "headline";
	}
}


