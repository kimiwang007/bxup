<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">
function onSubmit(cmd){
		var form = document.forms[0];
			form.action = "../event_update/{id}";
	
		form.submit();

		return false;
}
</script>
<head>

<title>editevent.jsp</title>
</head>	
<h2>编辑活动</h2>	
<body>
<form enctype="multipart/form-data" action="event/event_update/{id}" method="post">
		<table>	
				<input type="hidden" name="id" value="${id}"/>

				<tr>
					<td style="width: 70px">活动名称</td>
					<td style="width: 220px"><input type="text" name="event_name"
						id="eventName" size="35" maxlength="45" value="${event_name}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">活动标签</td>
					<td style="width: 220px"><input type="text" name="tag"
						id="tag" size="35" maxlength="45" value="${tag}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">开始日期</td>
					<td style="width: 220px"><input type="text" name="event_start_date"
						id="eventStartDate" size="35" maxlength="10" value="${event_start_date}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*请按照 yyyymmdd 格式输入</td>
				</tr>
				<tr>
					<td style="width: 70px">结束日期</td>
					<td style="width: 220px"><input type="text" name="event_end_date"
						id="eventEndDate" size="35" maxlength="10" value="${event_end_date}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*请按照 yyyymmdd 格式输入</td>
				</tr>
				
				<tr>
					<td style="width: 70px">开始时间</td>
					<td style="width: 220px"><input type="text" name="event_time"
						id="eventTime" size="35" maxlength="4" value="${event_time}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatTime(this)" /></td>
					<td>*请按照   hhmm (24-hour) 格式输入</td>
				</tr>
				<tr>
					<td style="width: 70px">活动链接</td>
					<td style="width: 220px"><input type="text" name="event_link"
						id="eventLink" size="35" maxlength="200" value="${event_link}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">活动简介</td>
					<td style="width: 220px"><textArea name="event_desc"
							id="eventDesc" cols="30" rows="4">${event_desc}</textArea></td>
				</tr>
				<tr>
					<td style="width: 70px">活动地址</td>
					<td style="width: 220px"><input type="text" name="event_place"
						id="eventPlace" size="35" maxlength="45" value="${event_place}" /></td>
				</tr>
				<tr>
	                <td style="width: 70px">当前适用图片:</td>			
					<td>${iphone4_img}</td><td><input type="hidden" name="iphone4_img"
						id="iphone4_img" value="${iphone4_img}" />
				</tr>
				<tr>		
					<td><input type="file" id="iPhone4IMG" name="iPhone4IMG" size="15" /></td>					
				</tr>
				<!-- 
				<tr>
					<td style="width: 70px">当前iPhone5适用图片:</td>	
					<td>${iphone5_img}</td><td><input type="hidden" name="iphone5_img"
						id="iphone5_img" value="${iphone5_img}" />		
				</tr>
				<tr>
					<td colspan="2"><input type="file" id="iPhone5IMG" name="iPhone5IMG" size="15" />
				</tr>
				<tr><td style="width: 70px">当前iPhone6适用图片:</td>	
					<td>${iphone6_img}</td><td><input type="hidden" name="iphone6_img"
						id="iphone6_img" value="${iphone6_img}" />		
				</tr>
				<tr>
					<td colspan="2"><input type="file" id="iPhone6IMG" name="iPhone6IMG" size="15" />
				</tr> 
				<tr>
				    <td style="width: 70px">当前iPhone6p适用图片:</td>	
					<td>${iphone6p_img}</td><td><input type="hidden" name="iphone6p_img"
						id="iphone6p_img" value="${iphone6p_img}" />		
				</tr>
				<tr>
					<td colspan="2"><input type="file" id="iPhone6PIMG" name="iPhone6PIMG" size="15" />
				</tr>  -->			
		</table>		
           <br> <input type="submit" value="保存" onclick="return onSubmit('Save');" class="input">
             	<input type="button"  class="blue_btn" value="返回" onclick="javascript:window.location.href='<%=basePath%>event'"/>	
</form>    
</body>

</html>