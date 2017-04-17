<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="true">
<head>
<title>eventadd.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function clearAll(){
	document.getElementById("name").value = "";
	document.getElementById("profile").value = "";
	document.getElementById("province").value = "";
	document.getElementById("city").value = "";
	document.getElementById("address").value = "";
	document.getElementById("tel").value = "";
	document.getElementById("tag").value = "";
	document.getElementById("hot").value = "";
	document.getElementById("gympicture1").value = "";
	document.getElementById("gympicture2").value = "";
	document.getElementById("gympicture3").value = "";
	document.getElementById("gympicture4").value = "";
	document.getElementById("gympicture5").value = "";
}

function onSubmit(cmd){
	var form = document.forms[0];
	form.action = "../gym_update";

	form.submit();
	
	return false;
}

function checkInput(){	
		if(document.getElementById("name").value == ""){
			alert("请填写健身房名称");
			document.getElementById("name").focus();
			return false;
		}
		if(document.getElementById("gympicture").value == ""){
			alert("请填写健身房图片");
			document.getElementById("gympicture").focus();
			return false;
		}
		if(document.getElementById("profile").value == ""){
			alert("请填写健身房档案");
			document.getElementById("profile").focus();
			return false;
		}		
		if(document.getElementById("address").value == ""){
			alert("请填写健身房地址");
			document.getElementById("address").focus();
			return false;
		}        
		if(document.getElementById("tel").value == ""){
			alert("请填写联系电话");
			document.getElementById("tel").focus();
			return false;
		}
		if(document.getElementById("tag").value == ""){
			alert("请添加标签");
			document.getElementById("tag").focus();
			return false;
		}
		if (isNaN(document.getElementById("hot").value)) {
			alert("请输入数字作为热度值！"); 
			document.getElementById("hot").focus();
		    return false;
		} 
	return true;
}
</script>

</head>
<body>
	<h2>健身房信息</h2>
	<form enctype="multipart/form-data" action="gym" method="post">

			<table>
				<tr>
					<td style="width: 70px">名字</td>
					<td style="width: 220px">
						<input type="hidden" name="id" value="${gymList.id}" />
						<input type="text" name="name"
						id="name" size="35" maxlength="45" value="${gymList.name}" /></td>
				</tr>			
				<tr>
					<td style="width: 70px">档案</td>
					<td style="width: 220px"><input type="text" name="profile"
						id="profile" size="35" value="${gymList.profile}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">省</td>
					<td style="width: 220px"><input type="text" name="province"
						id="province" size="35" maxlength="200" value="${gymList.province}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">市</td>
					<td style="width: 220px"><input type="text" name="city"
						id="city" size="35" maxlength="200" value="${gymList.city}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">地址</td>
					<td style="width: 220px"><input type="text" name="address"
						id="address" size="35" maxlength="200" value="${gymList.address}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">电话</td>
					<td style="width: 220px"><input type="text" name="tel"
						id="tel" size="35" maxlength="10" value="${gymList.tel}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">认证</td>
					<td style="width: 220px">
						<c:choose>
							<c:when test="${gymList.approved =='2'}">
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
					<input type="text" name="tag" id="tag" size="35" maxlength="200" value="${gymList.tag}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">热度</td>
					<td style="width: 220px"><input type="text" name="hot"
						id="hot" size="35" maxlength="200" value="${gymList.hot}" /></td>
				</tr>
				<tr>
					<td>图片1</td>
					<td colspan="2">
						<input type="hidden" name="gympictureName1" value="${gymList.gympictureName1}">
						<input type="hidden" name="photo1_id" value="${gymList.photo1_id}">
						<a href="${gymList.gympicture1}" target="_blank"><c:out value = "${gymList.gympictureName1}" /></a><br/>
						<input type="file" id="gympicture1" name="gympicture1" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片2</td>
					<td colspan="2">
						<input type="hidden" name="gympictureName2" value="${gymList.gympictureName2}">
						<input type="hidden" name="photo2_id" value="${gymList.photo2_id}">
						<a href="${gymList.gympicture2}" target="_blank"><c:out value = "${gymList.gympictureName2}" /></a><br/>
						<input type="file" id="gympicture2" name="gympicture2" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片3</td>
					<td colspan="2">
						<input type="hidden" name="gympictureName3" value="${gymList.gympictureName3}">
						<input type="hidden" name="photo3_id" value="${gymList.photo3_id}">
						<a href="${gymList.gympicture3}" target="_blank"><c:out value = "${gymList.gympictureName3}" /></a><br/>
						<input type="file" id="gympicture3" name="gympicture3" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片4</td>
					<td colspan="2">
						<input type="hidden" name="gympictureName4" value="${gymList.gympictureName4}">
						<input type="hidden" name="photo4_id" value="${gymList.photo4_id}">
						<a href="${gymList.gympicture4}" target="_blank"><c:out value = "${gymList.gympictureName4}" /></a><br/>
						<input type="file" id="gympicture4" name="gympicture4" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片5</td>
					<td colspan="2">
						<input type="hidden" name="gympictureName5" value="${gymList.gympictureName5}">
						<input type="hidden" name="photo5_id" value="${gymList.photo5_id}">
						<a href="${gymList.gympicture5}" target="_blank"><c:out value = "${gymList.gympictureName5}" /></a><br/>
						<input type="file" id="gympicture5" name="gympicture5" size="35" />
					</td>
				</tr>
				
				
			</table>

		<br> <input type="submit" value="上传"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button"  class="blue_btn" value="返回" onclick="javascript:window.location.href='<%=basePath%>gym'"/>	

	</form>