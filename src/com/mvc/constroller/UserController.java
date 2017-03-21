package com.mvc.constroller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.UserService;
import com.wang.form.UserForm;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	
	static Logger log = Logger.getLogger(ResourceController.class.getName());
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws Exception{
		log.info("showAllCoachInfo called");
		List<UserForm> user = userService.findAll();	
		
/*		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader()
				.getResourceAsStream("Webinfo.properties"));*/

		for(int i=0;i<user.size();i++){
		
			if(user.get(i).getGender() == 1){
				user.get(i).setSex("男");
			}else{
				user.get(i).setSex("女");
			}	

		
		}
 			
		mode.put("user", user);
		return "user";
	}

}
