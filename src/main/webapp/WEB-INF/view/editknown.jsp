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
			form.action = "../known_update/{id}";
	
		form.submit();

		return false;
}
</script>
<head>

<title>editknown.jsp</title>
</head>	
<h2>编辑知道</h2>	
<body>
<form enctype="multipart/form-data" action="known/known_update/{id}" method="post">
		<table>	
				<input type="hidden" name="id" value="${id}"/>
				<input type="hidden" name="summary" value="${summary}"/>
				<input type="hidden" name="publish_time" value="${publish_time}"/>
				<input type="hidden" name="subscribe_type" value="${subscribe_type}"/>
				<input type="hidden" name="status" value="${status}"/>
				<tr>
					<td style="width: 70px">标题</td>
					<td style="width: 220px"><input type="text" name="title"
						id="title" size="35" maxlength="45" value="${title}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">标签</td>
					<td style="width: 220px"><input type="text" name="tab"
						id="tab" size="35" maxlength="45" value="${tab}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">URL</td>
					<td style="width: 220px"><input type="text" name="url"
						id="url" size="35" maxlength="200" value="${url}" /></td>
				</tr>
				<tr>
	                <td style="width: 70px">推荐图片:</td>			
					<td>${feedimg}</td><td><input type="hidden" name="feedimg"
						id="feedimg" value="${feedimg}" />
				</tr>
				<tr>		
					<td><input type="file" id="feedimg" name="feedimg" size="15" />				
				<tr>
		</table>		
           <br> <input type="submit" value="保存" onclick="return onSubmit('Save');" class="input">
             	<input type="button"  class="blue_btn" value="返回" onclick="javascript:window.location.href='<%=basePath%>known'"/>	
</form>    
</body>

</html>