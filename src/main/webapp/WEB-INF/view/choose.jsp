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
<title>known.jsp</title>
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
<title>choose.jsp</title>
</head>	
<h2>精选一览</h2>	
<body>
<c:if test="${not empty message}">
	<div role="alert">
		<p>${message}</p>
	</div>
</c:if>
<br><input type="button"  class="blue_btn" value="新建精选" onclick="javascript:window.location.href='./subscribeAdd/choose'"/>
	<input type="button" value="推荐设定" onclick="setFeedIMG();"/>
	<input type="button" value="返回" onclick="back();"/>
	<table>
		<tr>
			<td>
				<div id="global">
					<table border="1">
						<tr>
							<th>No.</th>
							<th>设定Feed</th>
							<th>标题</th>
							<th>标签</th>
							<th>URL</th>	
							<th>推荐图片</th>	
						</tr>
						<c:forEach items="${choose}" var="item" varStatus="status">
							<tr>
								<td><c:out value = "${status.count}" /></td>
								<td>
									<c:choose>
										<c:when test="${item.feedImg != null}">
											<input type="checkbox" name="feedCheck" value="${item.id}" checked>
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="feedCheck" value="${item.id}">
										</c:otherwise>
									</c:choose>
								</td>	
								<td><c:out value = "${item.title}" /></td>
								<td><c:out value = "${item.tab}" /></td>
								<td><c:out value = "${item.url}" /></td>
								<td><c:out value = "${item.feedImg}" /></td>
								<input name='subscribe_type' type=hidden value="${item.subscribe_type}">
							</tr>
						</c:forEach>
					</table>	
				</div>
			</td>
		</tr>
	</table>
<script src="./resources/js/jquery-1.12.4.min.js"></script>
<SCRIPT Language="JavaScript">
function setFeedIMG(){
	if($('input[name="feedCheck"]:checked').size() > 2){
		alert("最大可以选择两项");
		return false;
	}
	var chk_value ="'";    
	$('input[name="feedCheck"]:checked').each(function(){  
		chk_value = chk_value + $(this).val() + "'";		
	});    
	javascript:window.location.href='./choose/' + chk_value;
}

function back(){
	if(window.confirm('是否返回导航画面 ?')){
		javascript:window.location.href='/bxadmin'
    }
}
</script>   
</body>
</html>