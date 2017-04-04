package com.bxup.bxup.service.impl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bxup.bxup.access.LoginDao;
import com.bxup.bxup.common.constant.CommonConstant;
import com.bxup.bxup.common.constant.ImgtypeEnum;
import com.bxup.bxup.constroller.RestController;
import com.bxup.bxup.model.Event;
import com.bxup.bxup.service.EventInsertService;


@Service
public class EventInsertServiceImpl implements EventInsertService{
	Event eventInsertForm = new Event();	
	
	public String insertEvent(Event eventInsertForm){
		Logger log = Logger.getLogger(RestController.class.getName());	
		LoginDao dao = null;
		int imgtype = 0;
		String img_type = eventInsertForm.getImg_Type();
		SimpleDateFormat formatter = new SimpleDateFormat(CommonConstant.YYYYMMDD);
		Date date = new Date();
		eventInsertForm.setCreateDate(formatter.format(date));
		
		try {
			
			
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("Webinfo.properties"));
			
			// img_type= 1 or 2

			if (img_type.equals(ImgtypeEnum.STRING_EVENT.getStringValue())
					|| img_type.equals(ImgtypeEnum.STRING_BANNER.getStringValue())) {
				
				imgtype = Integer.parseInt(img_type);				
				String eventStartdate = eventInsertForm.getEvent_start_date();		
				Date dbdate = formatter.parse(eventStartdate);
				eventStartdate = formatter.format(dbdate);
				eventInsertForm.setEventStartDate(formatter.format(dbdate));	
				String eventEnddate = eventInsertForm.getEvent_end_date();	
				dbdate = formatter.parse(eventEnddate);
				eventEnddate = formatter.format(dbdate);
				eventInsertForm.setEventEndDate(formatter.format(dbdate));
				eventInsertForm.setEventName(eventInsertForm.getEvent_name());
				eventInsertForm.setTag(eventInsertForm.getTag());
				eventInsertForm.setEventTime(eventInsertForm.getEvent_time());
				eventInsertForm.setEventLink(eventInsertForm.getEvent_link());
				eventInsertForm.setEventDesc(eventInsertForm.getEvent_desc());
				eventInsertForm.setEventPlace(eventInsertForm.getEvent_place());
				eventInsertForm.setiPhone4IMGName(eventInsertForm.getiPhone4IMGName());
				
				eventInsertForm.setiPhone6IMGName(eventInsertForm.getiPhone6IMGName());
				eventInsertForm.setiPhone6PIMGName(eventInsertForm.getiPhone6PIMGName());
				eventInsertForm.setDel_fg("0");
						
			} else if (img_type.equals(ImgtypeEnum.STRING_ICON.getStringValue())) {
				
				imgtype = Integer.parseInt(img_type);
				
				String start_date = eventInsertForm.getStartDate();
				String end_date = eventInsertForm.getEndDate();
				Date startdate = formatter.parse(start_date);
				Date enddate = formatter.parse(end_date);
				eventInsertForm.setStartDate(formatter.format(startdate));
				eventInsertForm.setEndDate(formatter.format(enddate));				
				eventInsertForm.setEventDef(eventInsertForm.getEventDef());
				eventInsertForm.setFriendDef(eventInsertForm.getFriendDef());
				eventInsertForm.setpKDef(eventInsertForm.getpKDef());
				eventInsertForm.setMetalDef(eventInsertForm.getMetalDef());
			} else if(img_type.equals(ImgtypeEnum.STRING_LOGINPICTURE.getStringValue())){
				imgtype = Integer.parseInt(img_type);
				eventInsertForm.setiPhone5IMGName(eventInsertForm.getIphone5_img());
				
			}
			dao = new LoginDao();
			String sucflg = LoginDao.AddT_event(eventInsertForm, imgtype);
			
			if(sucflg.equals(CommonConstant.FORWARD_SUCCESS)){
				log.info("PictureUploadSuccess");
				return CommonConstant.FORWARD_SUCCESS;
			}else{
				log.info("PictureUploadFailure");
				return CommonConstant.FORWARD_FAILURE;
			}
			
		} catch (IOException e) {		
			e.printStackTrace();
			return CommonConstant.FORWARD_FAILURE;
		} catch (Exception e) {			
			e.printStackTrace();
			return CommonConstant.FORWARD_FAILURE;
		}
	}
	
	
}
	



