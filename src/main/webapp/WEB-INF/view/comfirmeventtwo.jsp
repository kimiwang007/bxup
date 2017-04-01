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
			form.action = cmd;
	
		form.submit();

		return false;
}
</script>
<head>

<title>comfirmevent.jsp</title>
</head>	
<h2>Comfirm Event </h2>	
<body>
<form enctype="multipart/form-data" action="./maineventAdd" method="post">
		<table>
				<input type="hidden" name="img_Type" value="${img_Type}"/>			
				<tr>
					<td style="width: 70px">StartDate</td>
					<td style="width: 220px"><input type="text" name="startDate"
						id="eventStartDate" size="35" maxlength="10" value="${startDate}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" readonly/></td>				
				</tr>
				<tr>
					<td style="width: 70px">EndDate</td>
					<td style="width: 220px"><input type="text" name="endDate"
						id="eventEndDate" size="35" maxlength="10" value="${endDate}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" readonly/></td>				
				</tr>							
				<tr>
					<td style="width: 70px">EventDefName</td>
					<td style="width: 220px"><input type="text" name="eventDef"
						id="eventPlace" size="35" maxlength="45" value="${event_def}" readonly/></td>
				</tr> 
				
<%-- 				<tr>
					<td style="width: 70px">FriendDefName</td>
					<td style="width: 220px"><input type="text" name="friendDef"
						id="eventPlace" size="35" maxlength="45" value="${fri_def}" readonly/></td>
				</tr> 
				
				<tr>
					<td style="width: 70px">PkDefName</td>
					<td style="width: 220px"><input type="text" name="pKDef"
						id="eventPlace" size="35" maxlength="45" value="${pk_def}" readonly/></td>
				</tr> 
				
				<tr>
					<td style="width: 70px">MetalDef</td>
					<td style="width: 220px"><input type="text" name="metalDef"
						id="eventPlace" size="35" maxlength="45" value="${metal_def}" readonly/></td>
				</tr>   --%>
				
		</table>	
		<br><input type="submit" value="Upload" onclick="return onSubmit('./maineventAdd');" class="input">
		    <input type="submit"  class="blue_btn" value="Back" onclick="return onSubmit('./eventAdd');"/>	
           
</form>    
</body>

</html>