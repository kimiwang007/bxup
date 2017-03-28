<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>welcomePhoto.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">
	function back() {
		if (window.confirm('是否返回导航画面 ?')) {
			javascript: window.location.href = '/bxadmin'
		}
	}
</script>
</head>
<h2>闪屏列表</h2>
<body>
	<c:if test="${not empty message}">
		<div role="alert">
			<p>${message}</p>
		</div>
	</c:if>
	<br>
	<input type="button" class="blue_btn" value="变更闪屏"
		onclick="javascript:window.location.href='./welcomeimg/changeWelcomePhoto'" />
	<input type="button" value="返回" onclick="back();" />
	<table border="1">
		<tr>
			<th>开始日期</th>
			<th>结束日期</th>
			<th>创建时间</th>
			<th>iphone4闪屏</th>
			<th>iphone5闪屏</th>
			<th>iphone6闪屏</th>
			<th>iphone6p闪屏</th>
			<th>iphone7闪屏</th>
			<th>iphone7p闪屏</th>
		</tr>
		<c:forEach items="${welcomePhoto}" var="item" varStatus="status">
			<tr>
				<td><c:out value="${item.start_date}" /></td>
				<td><c:out value="${item.end_date}" /></td>
				<td><c:out value="${item.create_date}" /></td>
				<td><a href="${item.iphone4url}" target="_blank"><c:out value="${item.iphone4_img}" /></td>
				<td><a href="${item.iphone5url}" target="_blank"><c:out value="${item.iphone5_img}" /></td>
				<td><a href="${item.iphone6url}" target="_blank"><c:out value="${item.iphone6_img}" /></td>
				<td><a href="${item.iphone6purl}" target="_blank"><c:out value="${item.iphone6p_img}" /></td>
				<td><a href="${item.iphone7url}" target="_blank"><c:out value="${item.iphone7_img}" /></td>
				<td><a href="${item.iphone7purl}" target="_blank"><c:out value="${item.iphone7p_img}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>