<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>feedSet.jsp</title>
</head>
<body>
	<c:choose>
		<c:when test="${setType == 'known'}">
			<h2>知道推荐图片设定</h2>
		</c:when>
		<c:otherwise>
			<h2>精选推荐图片设定</h2>
		</c:otherwise>
	</c:choose>
	<form enctype="multipart/form-data" action="feedImgSave" method="post">
		<input type="hidden" value="${setType}" name="setType" id="setType">
		<c:forEach items="${items}" var="item" varStatus="status">
			<table border="0">
				<tr>
					<td colspan="2">
						<input type="hidden" id="itmeID[${status.count}]" name="itmeID" value="${item.id}">
						<c:out value = "${item.title}" />
					</td>
				</tr>
				<tr>
					<td>FEED:</td>
					<td>
						<input type="file" id="feedpicture[${status.count}]" name="feedpicture" size="35" />
					</td>
				</tr>
			</table>
		</c:forEach>
		<br> <input type="button" value="上传"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="返回" onclick="back();">

	</form>
	
<script src="../resources/js/jquery-1.12.4.min.js"></script>
<script src="../resources/js/test.js"></script>
<SCRIPT Language="JavaScript">
function onSubmit(cmd){
	if(checkInput()){
		var form = document.forms[0];	
		form.submit();
	}	
		return false;
}

function checkInput(){
	var reval = true;
	$('input[name="feedpicture"]').each(function(){    
		//chk_value.push($(this).val());		
		var fileName=$(this).val();
		if(fileName == ""){
			alert("请选择上传图片");
			$(this).focus()
			reval = false;
			return false;
		}
		var suffixIndex=fileName.lastIndexOf(".");
		var suffix=fileName.substring(suffixIndex+1).toUpperCase();
		if(suffix!="BMP"&&suffix!="JPG"&&suffix!="JPEG"&&suffix!="PNG"&&suffix!="GIF"){
			alert("请上传图片（格式BMP、JPG、JPEG、PNG、GIF等）!");
			$(this).focus()
			reval = false;
			return false;
		}
	});
	return reval;
}

function back(){
	if($('#setType').val() == "known"){
		if(window.confirm('是否返回知道列表 ?')){
			javascript:window.location.href='/bxadmin/known'
	    }
	} else {		
		if(window.confirm('是否返回精选列表 ?')){
			javascript:window.location.href='/bxadmin/choose'
	    }
	}
	
}
</SCRIPT>
</body>
</html>