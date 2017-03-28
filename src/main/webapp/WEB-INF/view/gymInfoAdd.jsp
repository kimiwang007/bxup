<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="true">
<head>
<title>eventadd.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function clearAll(){
	document.getElementById("name").value = "";
	document.getElementById("profile").value = "";
	document.getElementById("province").value = "";
	document.getElementById("city").value = "";
	document.getElementById("address").value = "";
	document.getElementById("tel").value = "";
	document.getElementById("tag").value = "";
	document.getElementById("hot").value = "";
	document.getElementById("gympicture1").value = "";
	document.getElementById("gympicture2").value = "";
	document.getElementById("gympicture3").value = "";
	document.getElementById("gympicture4").value = "";
	document.getElementById("gympicture5").value = "";
}

function onSubmit(cmd){
	if(checkInput()){
		var form = document.forms[0];	
		form.submit();
	}	
		return false;
}

function checkInput(){	
		if(document.getElementById("name").value == ""){
			alert("请填写体育馆名称");
			document.getElementById("name").focus();
			return false;
		}
		if(document.getElementById("gympicture").value == ""){
			alert("请填写体育馆图片");
			document.getElementById("gympicture").focus();
			return false;
		}
		if(document.getElementById("profile").value == ""){
			alert("请填写体育馆档案");
			document.getElementById("profile").focus();
			return false;
		}		
		if(document.getElementById("address").value == ""){
			alert("请填写体育馆地址");
			document.getElementById("address").focus();
			return false;
		}        
		if(document.getElementById("tel").value == ""){
			alert("请填写联系电话");
			document.getElementById("tel").focus();
			return false;
		}
		if(document.getElementById("tab").value == ""){
			alert("请添加标签");
			document.getElementById("tab").focus();
			return false;
		}
		if (isNaN(document.getElementById("hot").value)) {
			alert("请输入数字作为热度值！"); 
			document.getElementById("hot").focus();
		    return false;
		} 
	return true;
}


function back(){
	if(window.confirm('是否返回健身房列表 ?')){
		javascript:window.location.href='../gym'
     }
}

</script>

</head>
<body>
	<h2>健身房信息</h2>
	<form enctype="multipart/form-data" action="gymInfoAdd" method="post">

			<table>
				<tr>
					<td style="width: 70px">名字</td>
					<td style="width: 220px"><input type="text" name="name"
						id="name" size="35" maxlength="45" value="${name}" /></td>
				</tr>			
				<tr>
					<td style="width: 70px">档案</td>
					<td style="width: 220px"><input type="text" name="profile"
						id="profile" size="35" value="${profile}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">省</td>
					<td style="width: 220px"><input type="text" name="province"
						id="province" size="35" maxlength="200" value="${province}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">市</td>
					<td style="width: 220px"><input type="text" name="city"
						id="city" size="35" maxlength="200" value="${city}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">地址</td>
					<td style="width: 220px"><input type="text" name="address"
						id="address" size="35" maxlength="200" value="${address}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">电话</td>
					<td style="width: 220px"><input type="text" name="tel"
						id="tel" size="35" maxlength="10" value="${tel}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">认证</td>
					<td style="width: 220px"><input type="radio" name="approved" id="approved" value="1" checked>通过
                                             <input type="radio" name="approved" id="approved" value="2">未通过</td>
				</tr>
				<tr>
					<td style="width: 70px">标签</td>
					<td style="width: 220px"><font size="2" color="red">(*多标签记入时，请以','号分隔)</font>
					<input type="text" name="tag" id="tag" size="35" maxlength="200" value="${tag}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">热度</td>
					<td style="width: 220px"><input type="text" name="hot"
						id="hot" size="35" maxlength="200" value="${hot}" /></td>
				</tr>
				<tr>
					<td>图片1</td>
					<td colspan="2"><input type="file" id="gympicture1" name="gympicture1" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片2</td>
					<td colspan="2"><input type="file" id="gympicture2" name="gympicture2" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片3</td>
					<td colspan="2"><input type="file" id="gympicture3" name="gympicture3" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片4</td>
					<td colspan="2"><input type="file" id="gympicture4" name="gympicture4" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片5</td>
					<td colspan="2"><input type="file" id="gympicture5" name="gympicture5" size="35" />
					</td>
				</tr>
				
				
			</table>

		<br> <input type="submit" value="上传"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="返回" onclick="back();">
			 <input type="button" value="重置" onclick="clearAll();">

	</form>