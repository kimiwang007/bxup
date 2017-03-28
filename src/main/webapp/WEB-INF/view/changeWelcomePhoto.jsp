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
<title>changeWelcomePhoto.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">
	function clearAll() {
		document.getElementById("nickname").value = "";
		document.getElementById("mobile").value = "";
		document.getElementById("intro").value = "";
		document.getElementById("height").value = "";
		document.getElementById("weight").value = "";
		document.getElementById("age").value = "";
		document.getElementById("rate_fat").value = "";
	}

	function onSubmit(cmd) {
		if (checkInput()) {
			var form = document.forms[0];
			form.submit();
		}
		return false;
	}

	function checkInput() {
		if (document.getElementById("nickname").value == "") {
			alert("请填写您的用户名");
			document.getElementById("nickname").focus();
			return false;
		}
		if (document.getElementById("mobile").value == "") {
			alert("请填写您的手机号");
			document.getElementById("mobile").focus();
			return false;
		}
		if (document.getElementById("intro").value == "") {
			alert("请填写您的微信号");
			document.getElementById("intro").focus();
			return false;
		}
		return true;
	}

	function back() {
		if (window.confirm('是否返回闪屏一览 ?')) {
			javascript: window.location.href = 'welcomeimg'
		}
	}
</script>

</head>
<body>
	<h2>闪屏变更</h2>
	<form enctype="multipart/form-data" action="welcomePhotoAdd" method="post">

		<table>
			<tr>
				<td style="width: 70px">开始日期</td>
				<td style="width: 220px"><input type="text" name="startDate"
					id="startDate" size="35" maxlength="10" value="${startDate}"
					onfocus="this.style.imeMode='disabled'" /></td>
				<td>*请按照 yyyymmdd 格式输入</td>
			</tr>
			<tr>
				<td>结束日期</td>
				<td><input type="text" name="endDate" id="endDate" size="35"
					maxlength="10" value="${endDate}"
					onfocus="this.style.imeMode='disabled'"/></td>
				<td>*请按照 yyyymmdd 格式输入</td>
			</tr>
<!-- 			<tr>
				<td>iphone4闪屏图片</td>
				<td colspan="2"><input type="file" id="iphone4Img" name="iphone4Img" 
				    size="35"></td>
			</tr>
			<tr>
				<td>iphone5闪屏图片</td>
				<td colspan="2"><input type="file" id="iphone5Img" name="iphone5Img"
					size="35"></td>
			</tr>
			<tr>
				<td>iphone6闪屏图片</td>
				<td colspan="2"><input type="file" id="iphone6Img" name="iphone6Img"
					size="35"></td>
			</tr>
			<tr>
				<td>iphone6p闪屏图片</td>
				<td colspan="2"><input type="file" id="iphone6pImg" name="iphone6pImg" 
				    size="35"></td>
			</tr>
			<tr>
				<td>iphone7闪屏图片</td>
				<td colspan="2"><input type="file" id="iphone7Img" name="iphone7Img" 
				    size="35"></td>
			</tr>
			<tr>
				<td>iphone7p闪屏图片</td>
				<td colspan="2"><input type="file" id="iphone7pImg" name="iphone7pImg" 
				    size="35"></td>
			</tr> -->
		</table>

		<br> <input type="submit" value="上传"
			onclick="return onSubmit('Comfirm');" class="input"> <input
			type="button" value="返回" onclick="back();"> <input
			type="button" value="重置" onclick="clearAll();">

	</form>