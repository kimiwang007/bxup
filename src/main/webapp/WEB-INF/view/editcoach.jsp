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
			form.action = "../coach_update";
	
		form.submit();

		return false;
}
</script>
<head>

<title>editcoach.jsp</title>
</head>	
<h2>编辑教练</h2>	
<body>
<form enctype="multipart/form-data" action="coach" method="post">		
		<table>
				<tr>
					<td style="width: 70px">名字</td>
					<td style="width: 220px">
						<input type="hidden" name="id" value="${CoachList.id}" />
						<input type="text" name="name"
						id="name" size="35" maxlength="45" value="${CoachList.name}" /></td>
				</tr>			
				<tr>
					<td>头像</td>
					<td colspan="2">
						<input type="hidden" value="${CoachList.avatar}">
						<a href="${CoachList.pictureurl}" target="_blank"><c:out value = "${CoachList.avatar}" /></a><br/>
						<input type="file" id="photo" name="photo" size="35" />
					</td>
				</tr>
				<tr>
					<td style="width: 70px">性别</td>
				    <td style="width: 220px">
				    	<c:choose>
							<c:when test="${CoachList.gendar =='2'}">
								<input type="radio" name="gendar" id="gendar" value="1">男
								<input type="radio" name="gendar" id="gendar" value="2" checked>女
							</c:when>
							<c:otherwise>
								<input type="radio" name="gendar" id="gendar" value="1" checked>男
                                <input type="radio" name="gendar" id="gendar" value="2">女
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td style="width: 70px">年龄</td>
					<td style="width: 220px"><input type="text" name="age"
						id="age" size="35" maxlength="2" value="${CoachList.age}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">省</td>
					<td style="width: 220px"><input type="text" name="province"
						id="province" size="35" maxlength="200" value="${CoachList.province}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">市</td>
					<td style="width: 220px"><input type="text" name="city"
						id="city" size="35" maxlength="200" value="${CoachList.city}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">地址</td>
					<td style="width: 220px"><input type="text" name="address"
						id="address" size="35" maxlength="200" value="${CoachList.address}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">档案</td>
					<td style="width: 220px"><input type="text" name="profile"
						id="profile" size="35" value="${CoachList.profile}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">荣誉</td>
					<td style="width: 220px"><input type="text" name="honor"
						id="honor" size="35" maxlength="200" value="${CoachList.honor}" /></td>
				</tr>
				<tr>
					<td style="width: 75px">就职健身房</td>
					<td style="width: 220px">
					<select name="gym_id">
					<c:forEach var="gym" items="${gym}" varStatus="status">
						<c:choose>
							<c:when test="${CoachList.gym_name == gym.name}">
								<option value="${gym.id}" selected>${gym.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${gym.id}">${gym.name}</option>
							</c:otherwise>
						</c:choose>
						<option value="${gym.id}">${gym.name}</option>
					</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td style="width: 70px">认证</td>
					<td style="width: 220px">
						<c:choose>
							<c:when test="${CoachList.approved =='2'}">
								<input type="radio" name="approved" id="approved" value="1">通过
                        		<input type="radio" name="approved" id="approved" value="2" checked>未通过
							</c:when>
							<c:otherwise>
								<input type="radio" name="approved" id="approved" value="1" checked>通过
                        		<input type="radio" name="approved" id="approved" value="2">未通过
							</c:otherwise>
						</c:choose>
                    </td>
				</tr>
				<tr>
					<td style="width: 70px">标签</td>
					<td style="width: 220px"><font size="2" color="red">(*多标签记入时，请以','号分隔)</font>
						<input type="text" name="tag" id="tag" size="35" maxlength="200" value="${CoachList.tag}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">热度</td>
					<td style="width: 220px"><input type="text" name="hot"
						id="hot" size="35" maxlength="4" value="${CoachList.hot}" /></td>
				</tr>
				<tr>
					<td>图片1</td>
					<td colspan="2">
						<input type="hidden" name="pictureName1" value="${CoachList.pictureName1}">
						<input type="hidden" name="photo1_id" value="${CoachList.photo1_id}">
						<a href="${CoachList.picture1}" target="_blank"><c:out value = "${CoachList.pictureName1}" /></a><br/>
						<input type="file" id="picture1" name="picture1" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片2</td>
					<td colspan="2">
						<input type="hidden" name="pictureName2" value="${CoachList.pictureName2}">
						<input type="hidden" name="photo2_id" value="${CoachList.photo2_id}">
						<a href="${CoachList.picture2}" target="_blank"><c:out value = "${CoachList.pictureName2}" /></a><br/>
						<input type="file" id="picture2" name="picture2" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片3</td>
					<td colspan="2">
						<input type="hidden" name="pictureName3" value="${CoachList.pictureName3}">		
						<input type="hidden" name="photo3_id" value="${CoachList.photo3_id}">				
						<a href="${CoachList.picture3}" target="_blank"><c:out value = "${CoachList.pictureName3}" /></a><br/>
						<input type="file" id="picture3" name="picture3" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片4</td>
					<td colspan="2">
						<input type="hidden" name="pictureName4" value="${CoachList.pictureName4}">
						<input type="hidden" name="photo4_id" value="${CoachList.photo4_id}">
						<a href="${CoachList.picture4}" target="_blank"><c:out value = "${CoachList.pictureName4}" /></a><br/>
						<input type="file" id="picture4" name="picture4" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片5</td>
					<td colspan="2">
						<input type="hidden" name="pictureName5" value="${CoachList.pictureName5}">		
						<input type="hidden" name="photo5_id" value="${CoachList.photo5_id}">				
						<a href="${CoachList.picture5}" target="_blank"><c:out value = "${CoachList.pictureName5}" /></a><br/>
						<input type="file" id="picture5" name="picture5" size="35" />
					</td>
				</tr>
			</table>		
           <br> <input type="submit" value="保存" onclick="return onSubmit('Save');" class="input">
             	<input type="button"  class="blue_btn" value="返回" onclick="javascript:window.location.href='<%=basePath%>coach'"/>	
</form>    
</body>

</html>