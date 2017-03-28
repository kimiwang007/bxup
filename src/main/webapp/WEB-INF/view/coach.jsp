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
<head>
<title>resources.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">
function show(r){
	if(r.value=='1' || r.value=='2'){
		//alert(document.getElementById("c").border);
		document.getElementById("c").style.display ='block';// 
		document.getElementById("d").style.display ='none';
		clearAll();
	} else if(r.value=='3'){
		//alert(document.getElementById("c").border);
		document.getElementById("d").style.display ='block';//
		document.getElementById("c").style.display ='none';
		clearAll(); 
	} else {
		document.getElementById("c").style.display ='none';
		document.getElementById("d").style.display ='none';
	}
}
function delConfirm(itemId){	
	if(window.confirm('Are you sure delete the event?')){
		javascript:window.location.href='resources/event_delete/' + itemId
    }
}

function back(){
	if(window.confirm('是否返回导航画面 ?')){
		javascript:window.location.href='/bxadmin'
     }
}
</script>
</head>	
<h2>教练列表</h2>	
<body>
<c:if test="${not empty message}">
	<div role="alert">
		<p>${message}</p>
	</div>
</c:if>
<br><input type="button"  class="blue_btn" value="新建教练" onclick="javascript:window.location.href='./coach/coachInfo'"/>
	<input type="button" value="返回" onclick="back();"/>	
	<table>
		<tr>
			<td>
				<div id="global">
					<table border="1">
						<tr>
							<th>No.</th>
							<th>名字</th>
							<th>照片</th>
							<th>性别</th>
							<th>年龄</th>
							<th>省</th>
							<th>市</th>
							<th>地址</th>
							<th>档案</th>
							<th>荣誉</th>
							<th>就职健身房</th>
							<th>认证</th>
							<th>标签</th>
							<th>热度</th>
							<th>图片1</th>
							<th>图片2</th>
							<th>图片3</th>
							<th>图片4</th>
							<th>图片5</th>
						</tr>
						<c:forEach items="${coach}" var="item" varStatus="status">
							<tr>
								<td><c:out value = "${status.count}" /></td>
								<td><c:out value = "${item.name}" /></td>
								<td><a href="${item.pictureurl}" target="_blank"><c:out value = "${item.avatar}" /></a></td>
								<td><c:out value = "${item.sex}" /></td>
								<td><c:out value = "${item.age}" /></td>
								<td><c:out value = "${item.province}" /></td>
								<td><c:out value = "${item.city}" /></td>
								<td><c:out value = "${item.address}" /></td>
								<td><c:out value = "${item.profile}" /></td>							
								<td><c:out value = "${item.honor}" /></td>
								<td><c:out value = "${item.gym_name}" /></td>
								<td><c:out value = "${item.approvedfg}" /></td>
								<td><c:out value = "${item.tag}" /></td>
								<td><c:out value = "${item.hot}" /></td>
								<td><a href="${item.picture1}" target="_blank"><c:out value = "${item.pictureName1}" /></a></td>
								<td><a href="${item.picture2}" target="_blank"><c:out value = "${item.pictureName2}" /></a></td>
								<td><a href="${item.picture3}" target="_blank"><c:out value = "${item.pictureName3}" /></a></td>
								<td><a href="${item.picture4}" target="_blank"><c:out value = "${item.pictureName4}" /></a></td>
								<td><a href="${item.picture5}" target="_blank"><c:out value = "${item.pictureName5}" /></a></td>
							</tr>
						</c:forEach>
					</table>	
				</div>
			</td>
		</tr>
	</table>
    
</body>
</html>