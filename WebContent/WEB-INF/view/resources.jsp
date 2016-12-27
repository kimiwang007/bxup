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
</script>
</head>	
<h2>Event List</h2>	
<body>
<c:if test="${not empty message}">
	<div role="alert">
		<p>${message}</p>
	</div>
</c:if>
<br><input type="button"  class="blue_btn" value="NEW" onclick="javascript:window.location.href='./eventAdd'"/>
	<table>
		<tr>
			<td>
				<div id="global">
					<table border="1">
						<tr>
							<th>ID</th>
							<th>EventName</th>
							<th>EventStartDate</th>
							<th>EventEndDate</th>
							<th>EventTime</th>
							<th>EventLink</th>
							<th>EventDesc</th>
							<th>EventPlace</th>
						</tr>
						<c:forEach items="${resources}" var="item" varStatus="status">
							<tr>
								<td><c:out value = "${status.count}" /></td>
								<td><c:out value = "${item.event_name}" /></td>
								<td><c:out value = "${item.event_start_date}" /></td>
								<td><c:out value = "${item.event_end_date}" /></td>
								<td><c:out value = "${item.event_time}" /></td>
								<td><c:out value = "${item.event_link}" /></td>							
								<td><c:out value = "${item.event_desc}" /></td>
								<td><c:out value = "${item.event_place}" /></td>
								<td><input type="button" onclick="javascript:window.location.href='resources/event_edit/${item.id}'" value="Edit"></td>
								<td><input type="button" onclick="delConfirm(${item.id});" value="Delete"></td>
							</tr>							
						</c:forEach>
					</table>	
				</div>
			</td>
		</tr>
	</table>
    
</body>
</html>