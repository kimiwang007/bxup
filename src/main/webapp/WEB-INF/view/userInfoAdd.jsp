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
<title>useradd.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function clearAll(){
	document.getElementById("nickname").value = "";
	document.getElementById("mobile").value = "";
	document.getElementById("intro").value = "";
	document.getElementById("height").value = "";
	document.getElementById("weight").value = "";
	document.getElementById("age").value = "";
	document.getElementById("rate_fat").value = "";
}

function onSubmit(cmd){
	if(checkInput()){
		var form = document.forms[0];	
		form.submit();
	}	
		return false;
}

function checkInput(){	
		if(document.getElementById("nickname").value == ""){
			alert("请填写您的用户名");
			document.getElementById("nickname").focus();
			return false;
		}
		if(document.getElementById("mobile").value == ""){
			alert("请填写您的手机号");
			document.getElementById("mobile").focus();
			return false;
		}
		if(document.getElementById("intro").value == ""){
			alert("请填写您的微信号");
			document.getElementById("intro").focus();
			return false;
		}		
		if(document.getElementById("height").value == ""){
			alert("请填写您的身高");
			document.getElementById("height").focus();
			return false;
		}        
		if(document.getElementById("weight").value == ""){
			alert("请填写您的体重");
			document.getElementById("weight").focus();
			return false;
		}
		if(document.getElementById("rate_fat").value == ""){
			alert("请填写您的体脂率");
			document.getElementById("rate_fat").focus();
			return false;
		} 
		if (isNaN(document.getElementById("age").value)) {
			alert("年龄请输入数字！"); 
			document.getElementById("age").focus();
		    return false;
		} 
	return true;
}


function back(){
	if(window.confirm('是否返回用户列表 ?')){
		javascript:window.location.href='user'
     }
}

</script>

</head>
<body>
	<h2>用户信息</h2>
	<form enctype="multipart/form-data" action="userAdd" method="post">

			<table>
				<tr>
					<td style="width: 70px">用户名</td>
					<td style="width: 220px"><input type="text" name="nickname"
						id="nickname" size="35" maxlength="45" value="${nickname}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">手机号</td>
					<td style="width: 220px"><input type="text" name="mobile"
						id="mobile" size="35" maxlength="45" value="${mobile}" /></td>
				</tr>				
				<tr>
					<td style="width: 70px">微信号</td>
					<td style="width: 220px"><input type="text" name="intro"
						id="intro" size="35" maxlength="45" value="${intro}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">平台ID</td>
					<td style="width: 220px"><input type="text" name="intro"
						id="intro" size="35" maxlength="45" value="999999999" disabled="disabled"/></td>
				</tr>
				<tr>
					<td style="width: 70px">身高</td>
					<td style="width: 220px"><input type="text" name="height"
						id="height" size="35" maxlength="45" value="${height}" /></td>
				</tr>			
				<tr>
					<td style="width: 70px">体重</td>
					<td style="width: 220px"><input type="text" name="weight"
						id="weight" size="35" maxlength="45" value="${weight}" /></td>
				</tr>

				<tr>
					<td style="width: 70px">性别</td>
				    <td style="width: 220px"><input type="radio" name="gendar" id="gendar" value="1" checked>男
                                             <input type="radio" name="gendar" id="gendar" value="2">女</td>
				</tr>
				<tr>
					<td style="width: 70px">年龄</td>
					<td style="width: 220px"><input type="text" name="age"
						id="age" size="35" maxlength="2" value="${age}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">体脂率</td>
					<td style="width: 220px"><input type="text" name="rate_fat"
						id="rate_fat" size="35" value="${rate_fat}"/></td>
				</tr>				
			</table>

		<br> <input type="submit" value="上传"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="返回" onclick="back();">
			 <input type="button" value="重置" onclick="clearAll();">

	</form>