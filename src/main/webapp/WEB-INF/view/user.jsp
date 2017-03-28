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
<h2>用户列表</h2>	
<body>
<c:if test="${not empty message}">
	<div role="alert">
		<p>${message}</p>
	</div>
</c:if>
<br><input type="button"  class="blue_btn" value="新建用户" onclick="javascript:window.location.href='./userInfoAdd'"/>
	<input type="button" value="用户一览CSV取得" onclick="exportConfirm()"/>
	<input type="button" value="返回" onclick="back();"/>
	<table>
		<tr>
			<td>
				<div id="global">
					<table border="1">
						<tr>
							<th>No.</th>
							<th>名称</th>
							<th>手机号</th>
							<th>微信号</th>
							<th>平台ID</th>
							<th>身高</th>
							<th>体重</th>
							<th>性别</th>
							<th>年龄</th>
							<th>体脂率</th>
						</tr>
						<c:forEach items="${user}" var="item" varStatus="status">
							<tr>
								<td><c:out value = "${status.count}" /></td>
								<td><c:out value = "${item.nickname}" /></td>
								<td><c:out value = "${item.mobile}" /></td>
								<td><c:out value = "${item.intro}" /></td>
								<td><c:out value = "${item.platform_id}" /></td>						
																	
								<td><c:out value = "${item.height}" /></td>
								<td><c:out value = "${item.weight}" /></td>
								<td><c:out value = "${item.sex}" /></td>
								<td><c:out value = "${item.age}" /></td>
								<td><c:out value = "${item.rate_fat}" /></td>
								<%-- 			<td><a href="${item.pictureurl}" target="_blank"><c:out value = "${item.avatar}" /></a></td> --%>	
<%-- 								<td><input type="button" onclick="javascript:window.location.href='resources/event_edit/${item.id}'" value="编辑"></td>
								<td><input type="button" onclick="delConfirm(${item.id});" value="删除"></td> --%>
							</tr>
						</c:forEach>
					</table>	
				</div>
			</td>
		</tr>
	</table>
<script src="./resources/js/jquery-1.12.4.min.js"></script>
<script src="./resources/js/test.js"></script>
<SCRIPT Language="JavaScript">

/**数据库导出确认*/
function exportConfirm(){
    var url = "./user/csvExport"
    window.open(url);
}

function back(){
	if(window.confirm('是否返回导航画面 ?')){
		javascript:window.location.href='/bxadmin'
     }
}
</script>   
</body>
</html>