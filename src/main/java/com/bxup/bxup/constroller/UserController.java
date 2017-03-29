package com.bxup.bxup.constroller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bxup.bxup.model.User;
import com.bxup.bxup.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	static Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String showAllResource(Map<String, Object> mode) throws Exception {
		log.info("showAllCoachInfo called");
		List<User> user = userService.findAll();
		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).getGender() == null){
				user.get(i).setSex("");
			} else {
				if (user.get(i).getGender() == 1) {
					user.get(i).setSex("男");
				} else {
					user.get(i).setSex("女");
				}
			}			
		}

		mode.put("user", user);
		return "user";
	}

	@RequestMapping(value = "/csvExport", method = RequestMethod.GET)
	public void csvExport(HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			List<User> users = userService.findAll();
			response.reset();
			response.setContentType("application/csv;charset=UTF-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=orderData " + new Timestamp(System.currentTimeMillis()) + ".csv");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(
					"user_id,platform_id,mobile,avatar,intro,nickname,gender,address,height,weight,age,rate_fat,goal,create_time,last_login_time,last_login_ip,device_type");
			// out.println("user_id,platform_id,手机号,avatar,微信号,用户名,性别,address,身高,体重,年龄,体脂率,goal,create_time,last_login_time,last_login_ip,device_type");
			for (int i = 0, length = users.size(); i < length; i++) {
				User user = users.get(i);
				String createTime = new String();
				String lastLoingTime = new String();
				if (user.getCreate_time() != null) {
					createTime = sdf.format(user.getCreate_time());
				}
				if (user.getLast_login_time() != null) {
					lastLoingTime = sdf.format(user.getLast_login_time());
				}

				String str = user.getUser_Id() + "," + user.getPlatform_id() + "," + user.getMobile() + ","
						+ user.getAvatar() + "," + user.getIntro() + "," + user.getNickname() + "," + user.getGender()
						+ "," + user.getAddress() + "," + user.getHeight() + "," + user.getWeight() + ","
						+ user.getAge() + "," + user.getRate_fat() + "," + user.getGoal() + "," + createTime + ","
						+ lastLoingTime + "," + user.getLast_login_ip() + "," + user.getDevice_type();
				str = str.replace("null", "");
				out.println(str);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
