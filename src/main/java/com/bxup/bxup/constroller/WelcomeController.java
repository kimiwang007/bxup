package com.bxup.bxup.constroller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	static Logger log = Logger.getLogger(WelcomeController.class.getName());

	@RequestMapping(value = "/welcome1", method = RequestMethod.GET)
	public String eventresources() {
		log.info("WelcomePage called");
		return "redirect:/resources";
	}

	@RequestMapping(value = "/welcome2", method = RequestMethod.GET)
	public String coachresources() {
		log.info("WelcomePage called");
		return "redirect:/coach";
	}

	@RequestMapping(value = "/welcome3", method = RequestMethod.GET)
	public String mgyresources() {
		log.info("WelcomePage called");
		return "redirect:/gym";
	}

	@RequestMapping(value = "/welcome4", method = RequestMethod.GET)
	public String feedback() {
		log.info("WelcomePage called");

		return "redirect:/feedback";
	}

	@RequestMapping(value = "/welcome5", method = RequestMethod.GET)
	public String known() {
		log.info("WelcomePage called");
		return "redirect:/known";
	}

	@RequestMapping(value = "/welcome6", method = RequestMethod.GET)
	public String choose() {
		log.info("WelcomePage called");
		return "redirect:/choose";
	}

	@RequestMapping(value = "/welcome7", method = RequestMethod.GET)
	public String user() {
		log.info("WelcomePage called");
		return "redirect:/user";
	}

	@RequestMapping(value = "/welcome8", method = RequestMethod.GET)
	public String show() {
		log.info("WelcomePage called");
		return "redirect:/show";
	}

	@RequestMapping(value = "/welcome9", method = RequestMethod.GET)
	public String headline() {
		log.info("WelcomePage called");
		return "redirect:/headline";
	}

	@RequestMapping(value = "/welcome10", method = RequestMethod.GET)
	public String welcomeimg() {
		log.info("WelcomePage called");
		return "redirect:/welcomeimg";
	}

	@RequestMapping(value = "/welcome11", method = RequestMethod.GET)
	public String community() {
		log.info("WelcomePage called");
		return "redirect:/community";
	}
}
