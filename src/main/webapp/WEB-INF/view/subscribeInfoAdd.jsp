<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="true">
<head>
<title>subscribeInfoadd.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function clearAll(){
	document.getElementById("title").value = "";
	document.getElementById("tab").value = "";
	document.getElementById("url").value = "";
}

function onSubmit(cmd){
	if(checkInput()){
		var form = document.forms[0];	
		form.submit();
	}	
		return false;
}

function checkInput(){
		if(document.getElementById("subscribe_type").value == ""){
			alert("请选择要添加的类型");
			document.getElementById("subscribe_type").focus();
			return false;
		}
		if(document.getElementById("title").value == ""){
			alert("请填写标题");
			document.getElementById("title").focus();
			return false;
		}
		if(document.getElementById("tab").value == ""){
			alert("请填写简介");
			document.getElementById("tab").focus();
			return false;
		}
		if(document.getElementById("url").value == ""){
			alert("请填写URL");
			document.getElementById("url").focus();
			return false;
		}		
	return true;
}


function back(){
	if(document.getElementById("subscribe_type").value == "2"){
		if(window.confirm('是否返回知道列表 ?')){
			javascript:window.location.href='/bxadmin/known';
	    }
	} else if(document.getElementById("subscribe_type").value == "3") {
		if(window.confirm('是否精选列表 ?')){
			javascript:window.location.href='/bxadmin/choose';
	    }
	} else if(document.getElementById("subscribe_type").value == "0") {
		if(window.confirm('是否社区列表 ?')){
			javascript:window.location.href='/bxadmin/community';
	    }
	} else {
		if(window.confirm('是否返回头条列表 ?')){
			javascript:window.location.href='/bxadmin/headline';
	    }		
	}
	
}

</script>

</head>
<body>
	<h2></h2>
	<form enctype="multipart/form-data" action="../subscribeInfoAdd"
		method="post">

		<table>
			<tr>
				<td><c:choose>
						<c:when test="${subscribe_type =='known'}">
							<h2>新建知道</h2>
						</c:when>
						<c:when test="${subscribe_type =='headline'}">
							<h2>新建头条</h2>
						</c:when>
						<c:when test="${subscribe_type =='choose'}">
							<h2>新建精选</h2>
						</c:when>
						<c:otherwise>
							<h2>新建社区</h2>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td style="width: 70px">标题</td>
				<td style="width: 220px"><input type="text" name="title"
					id="title" size="35" maxlength="45" value="${title}" /></td>
			</tr>
			<tr>
				<td style="width: 70px">简介</td>
				<td style="width: 220px"><input type="text" name="tab" id="tab"
					size="35" value="${tab}" /></td>
			</tr>
			<tr>
				<td style="width: 70px">URL</td>
				<td style="width: 220px"><input type="text" name="url" id="url"
					size="35" maxlength="200" value="${url}" /></td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${subscribe_type =='known'}">
						<td>图片</td>
						<td colspan="2"><input type="file" id="knownpicture"
							name="knownpicture" size="35" /></td>
					</c:when>
					<c:when test="${subscribe_type =='community'}">
						<td>图片</td>
						<td colspan="2"><input type="file" id="knownpicture"
							name="knownpicture" size="35" /></td>
					</c:when>
					<c:when test="${subscribe_type =='choose'}">
						<td>图片</td>
						<td colspan="2"><input type="file" id="knownpicture"
							name="knownpicture" size="35" /></td>
					</c:when>
				</c:choose>
			</tr>
		</table>
		<br>
			<c:choose>
				<c:when test="${subscribe_type =='known'}">
					<input type="hidden" value="2" name="subscribe_type" id="subscribe_type">
				</c:when>
				<c:when test="${subscribe_type =='headline'}">
					<input type="hidden" value="1" name="subscribe_type" id="subscribe_type">
				</c:when>
				<c:when test="${subscribe_type =='choose'}">
					<input type="hidden" value="3" name="subscribe_type" id="subscribe_type">
				</c:when>
				<c:otherwise>
					<input type="hidden" value="0" name="subscribe_type" id="subscribe_type">
				</c:otherwise>
			</c:choose>			
			<input type="submit" value="上传" onclick="return onSubmit('Comfirm');" class="input"> 
			<input type="button" value="返回" onclick="back();"> 
			<input type="button" value="重置" onclick="clearAll();">

	</form>