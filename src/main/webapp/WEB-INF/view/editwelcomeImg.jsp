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
		document.getElementById("start_date").value = "";
		document.getElementById("end_date").value = "";
		document.getElementById("iphone4").value = "";
		document.getElementById("iphone5").value = "";
		document.getElementById("iphone6").value = "";
		document.getElementById("iphone6p").value = "";
		document.getElementById("iphone7").value = "";
		document.getElementById("iphone7p").value = "";
	}

	function onSubmit(cmd) {
		if (checkInput()) {
			var form = document.forms[0];
			form.submit();
		}
		return false;
	}

	function back() {
		if (window.confirm('是否返回闪屏一览 ?')) {
			javascript: window.location.href = '<%=basePath%>welcomeimg'
		}
	}
</script>

</head>
<body>
	<h2>添加闪屏</h2>
	<c:if test="${not empty message}">
		<div role="alert" class="Toglle col-xs-12">
			<p>${message}</p>
		</div>
	</c:if>
	<form enctype="multipart/form-data" action="../welcomeimg_update" method="post">
		<table>
			<tr>
				<td style="width: 70px">开始日期</td>
				<td style="width: 220px">
					<input type="hidden" name="id" id="id" value="${welcomeImg.id}"/>
					<input type="text" name="start_date" id="start_date" size="35" maxlength="10" value="${welcomeImg.start_date}"/></td>
				<td>*请按照 yyyymmdd 格式输入</td>
			</tr>
			<tr>
				<td>结束日期</td>
				<td><input type="text" name="end_date" id="end_date" size="35"
					maxlength="10" value="${welcomeImg.end_date}"/></td>
				<td>*请按照 yyyymmdd 格式输入</td>
			</tr>
 			<tr>
				<td>iphone4闪屏图片</td>
				<td colspan="2">
					<c:out value="${welcomeImg.iphone4_img}"></c:out>
					<input type="hidden" name="iphone4_img" id="iphone4_img" value="${welcomeImg.iphone4_img}"/><br/>
					<input type="file" id="iphone4" name="iphone4" size="35">
				</td>
			</tr>
			<tr>
				<td>iphone5闪屏图片</td>
				<td colspan="2">
					<c:out value="${welcomeImg.iphone5_img}"></c:out>
					<input type="hidden" name="iphone5_img" id="iphone5_img" value="${welcomeImg.iphone5_img}"/><br/>
					<input type="file" id="iphone5" name="iphone5"	size="35">
				</td>
			</tr>
			<tr>
				<td>iphone6闪屏图片</td>
				<td colspan="2">
					<c:out value="${welcomeImg.iphone6_img}"></c:out>
					<input type="hidden" name="iphone6_img" id="iphone6_img" value="${welcomeImg.iphone6_img}"/><br/>
					<input type="file" id="iphone6" name="iphone6" size="35">
				</td>
			</tr>
			<tr>
				<td>iphone6p闪屏图片</td>
				<td colspan="2">
					<c:out value="${welcomeImg.iphone6p_img}"></c:out>
					<input type="hidden" name="iphone6p_img" id="iphone6p_img" value="${welcomeImg.iphone6p_img}"/><br/>
					<input type="file" id="iphone6p" name="iphone6p" size="35">
				</td>
			</tr>
			<tr>
				<td>iphone7闪屏图片</td>
				<td colspan="2">
					<c:out value="${welcomeImg.iphone7_img}"></c:out>
					<input type="hidden" name="iphone7_img" id="iphone7_img" value="${welcomeImg.iphone7_img}"/><br/>
					<input type="file" id="iphone7" name="iphone7" size="35">
				</td>
			</tr>
			<tr>
				<td>iphone7p闪屏图片</td>
				<td colspan="2">
					<c:out value="${welcomeImg.iphone7p_img}"></c:out>
					<input type="hidden" name="iphone7p_img" id="iphone7p_img" value="${welcomeImg.iphone7p_img}"/><br/>
					<input type="file" id="iphone7p" name="iphone7p" size="35">
				</td>
			</tr>
		</table>

		<br> <input type="submit" value="上传"
			onclick="return onSubmit('Comfirm');" class="input"> <input
			type="button" value="返回" onclick="back();"> <input
			type="button" value="重置" onclick="clearAll();">

	</form>