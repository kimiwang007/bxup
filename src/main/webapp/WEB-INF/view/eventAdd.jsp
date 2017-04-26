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

function show(r){
	if(r.value=='1' || r.value=='2'){
		//alert(document.getElementById("c").border);
		document.getElementById("c").style.display ='block';// 
		document.getElementById("d").style.display ='none';
		document.getElementById("gymDiv").style.display ='none';
		document.getElementById("loginpictureDiv").style.display ='none';
		clearAll();
	} else if(r.value=='3'){
		//alert(document.getElementById("c").border);
		document.getElementById("d").style.display ='block';//
		document.getElementById("c").style.display ='none';
		document.getElementById("gymDiv").style.display ='none';
		document.getElementById("loginpictureDiv").style.display ='none';
		clearAll(); 
	} else if(r.value=='4'){
		document.getElementById("loginpictureDiv").style.display ='block';
		document.getElementById("d").style.display ='none';
		document.getElementById("c").style.display ='none';
		document.getElementById("gymDiv").style.display ='none';
		clearAll(); 
	}  else if(r.value=='5'){
		document.getElementById("gymDiv").style.display ='block';
		document.getElementById("loginpictureDiv").style.display ='none';
		document.getElementById("d").style.display ='none';
		document.getElementById("c").style.display ='none';
		clearAll(); 
	} else {
		document.getElementById("c").style.display ='none';
		document.getElementById("d").style.display ='none';
		document.getElementById("gymDiv").style.display ='none';
		document.getElementById("loginpictureDiv").style.display ='none';
	}
}

function back(){
	if(window.confirm('是否返回活动列表 ?')){
		javascript:window.location.href='event'
     }
}

function clearAll(){
	document.getElementById("eventName").value = "";
	document.getElementById("eventStartDate").value = "";
	document.getElementById("eventEndDate").value = "";
	document.getElementById("eventTime").value = "";
	document.getElementById("eventLink").value = "";
	document.getElementById("eventDesc").value = "";
	document.getElementById("eventPlace").value = "";
	document.getElementById("iPhone4IMG").value = "";
	document.getElementById("iPhone5IMG").value = "";
	document.getElementById("iPhone6IMG").value = "";
	document.getElementById("iPhone6PIMG").value = "";
	
	document.getElementById("startDate").value = "";
	document.getElementById("endDate").value = "";
	document.getElementById("event_def").value = "";
	document.getElementById("fri_def").value = "";
	document.getElementById("pk_def").value = "";
	document.getElementById("metal_def").value = "";
	
	document.getElementById("coachCsv").value = "";
	document.getElementById("gymCsv").value = "";
}

function onSubmit(cmd){
	var rtn = document.getElementsByName("img_Type");
	var rtnValue = '';
	for (var i=0;i<rtn.length;i++){ 
		if(rtn[i].checked){ 
			rtnValue=rtn[i].value; 
		} 
	}
	if(rtnValue == ''){
		alert("请选择一个项目");
		return false;
	}
	if(checkInput()){
		var form = document.forms[0];
		if(rtnValue=='1' || rtnValue=='2' || rtnValue=='3'){
			form.action = "./comfirmeventAdd";
		} else if(rtnValue=='4'){
			form.action = "./loginpictureAdd";
		} else if(rtnValue=='5'){
			form.action = "./gymAdd";
		}		
		form.submit();
	}	
		return false;
}

function checkInput(){
	
	if(document.getElementById("1").status == true || document.getElementById("2").status == true){
		if(document.getElementById("eventName").value == ""){
			alert("请填写活动名称");
			document.getElementById("eventName").focus();
			return false;
		}
		if(document.getElementById("eventStartDate").value == ""){
			alert("请填写开始日期");
			document.getElementById("eventStartDate").focus();
			return false;
		}
		if(document.getElementById("eventEndDate").value == ""){
			alert("请填写结束日期");
			document.getElementById("eventEndDate").focus();
			return false;
		}		
		if(document.getElementById("eventTime").value == ""){
			alert("请填写开始时间");
			document.getElementById("eventTime").focus();
			return false;
		}        
		if(document.getElementById("eventLink").value == ""){
			alert("请填加活动链接");
			document.getElementById("eventLink").focus();
			return false;
		}
		if(document.getElementById("eventDesc").value == ""){
			alert("请填加活动简介");
			document.getElementById("eventDesc").focus();
			return false;
		} 
	
		if(document.getElementById("eventPlace").value == ""){
			alert("请填加活动地点");
			document.getElementById("eventPlace").focus();
			return false;
		}
	} else if(document.getElementById("3").status == true) {
		if(document.getElementById("startDate").value == ""){
			alert("请填写开始日期");
			document.getElementById("startDate").focus();
			return false;
		}      
	
		if(document.getElementById("endDate").value == ""){
			alert("请填写结束日期");
			document.getElementById("endDate").focus();
			return false;
		}  
	} /* else if(document.getElementById("4").status == true){
		if(document.getElementById("coachCsv").value == ""){
			alert("Please fill in the coachCsv");
			return false;
		}
		if(document.getElementById("coachCsv").value.indexOf(".csv") == -1 ) {
			alert("Please fill in the .csv file");
			return false;
		}
		
	} else if(document.getElementById("5").status == true){
		if(document.getElementById("gymCsv").value == ""){
			alert("Please fill in the gymCsv");
			return false;
		}
		if(document.getElementById("gymCsv").value.indexOf(".csv") == -1 ) {
			alert("Please fill in the .csv file");
			return false;
		}
	} */

	return true;
}

	
function formatDate(date){ 
	if(date.value.length == 8){
		var value = date.value;
		var reg=/^\d+$/;
		var ret=/^(?:(?!0000)[0-9]{4}\/(?:(?:0[1-9]|1[0-2])\/(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])\/(?:29|30)|(?:0[13578]|1[02])\/31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)\/02\/29)$/;
		if(reg.test(value)==true){			
				var y = date.value.substring(0,4);
			    if(y<1800 || y > 2100){
			    	alert("1800-2100之间的年份");
			    	date.value = "";
			    	date.focus();
			    	return false;
			    	}	
			    var m = date.value.substring(4,6);	      			       	     
			    var d = date.value.substring(6,8);
			    var eventDate  = y + '/' + m + '/' + d;
				    if(ret.test(eventDate)==true) {
				    	var eventStartDate = document.getElementById("eventStartDate").value.replace(/\//g,'');
				    	var eventEndDate = document.getElementById("eventEndDate").value.replace(/\//g,'');
				    	if(eventStartDate != "" && eventEndDate !="" && eventStartDate > eventEndDate){
				    		alert("开始日期不能在结束日期之后");
				    		date.value = "";
							date.focus();
							return false;
				    	}
				    	date.value = eventDate;
						return true;
					}else{
						alert("请按照提示信息输入");
						date.value = "";
						date.focus();
						return false;
						}    		    			       
		}else{ 
		    alert("请输入0-9 数字 ");
		    date.value = "";
		    date.focus();
		    return false;
		}	  
	}else{
		alert("请按照 yyyymmdd 格式输入");
		date.value = "";
		date.focus();
    	return false;
		} 
}

function formatTime(time){
	if(time.value.length == 4){
		var value = time.value;
		var reg=/^\d+$/;
		var ret=/^(([0-1]\d)|(2[0-4]))[0-5]\d$/;
		if(reg.test(value)== true){			
				    if(ret.test(value)==true) {
				    	time.value = value;
						return true;
					}else{
						alert("请按照提示信息输入");
						time.value = "";
						time.focus();
						return false;
						}    		    			       
		}else{
		    alert("请输入0-9 数字");
		    time.value = "";
		    time.focus();
		    return false;
		}	  
	}else{
		alert("请按照 hhmm 格式输入");
		time.value = "";
		time.focus();
    	return false;
		} 
}

function load(){
	var impType = '${img_Type}';
	if(impType=='1' || impType=='2'){
		if(impType=='1'){
			document.getElementById("1").checked =true;
		}else{
			document.getElementById("2").checked =true;
		}
		document.getElementById("c").style.display ='block';// 
		document.getElementById("d").style.display ='none';
		document.getElementById("gymDiv").style.display ='none';
		document.getElementById("loginpictureDiv").style.display ='none';
	} else if(impType=='3'){
		document.getElementById("3").checked =true;
		document.getElementById("d").style.display ='block';//
		document.getElementById("c").style.display ='none';
		document.getElementById("gymDiv").style.display ='none';
		document.getElementById("loginpictureDiv").style.display ='none';
	} else if(impType=='4'){
		document.getElementById("4").checked =true;
		document.getElementById("loginpictureDiv").style.display ='block';
		document.getElementById("d").style.display ='none';
		document.getElementById("c").style.display ='none';
		document.getElementById("gymDiv").style.display ='none';
	}  else if(impType=='5'){
		document.getElementById("5").checked =true;
		document.getElementById("gymDiv").style.display ='block';
		document.getElementById("loginpictureDiv").style.display ='none';
		document.getElementById("d").style.display ='none';
		document.getElementById("c").style.display ='none';
	} else {
		document.getElementById("c").style.display ='none';
		document.getElementById("d").style.display ='none';
		document.getElementById("gymDiv").style.display ='none';
		document.getElementById("loginpictureDiv").style.display ='none';
	}
}

</script>

</head>
<body onload="load()">
	<h2>新建活动</h2>
	<form enctype="multipart/form-data" action="maineventAdd" method="post">

		<input type="radio" name="img_Type" id="1" value="1"
			onclick="show(this)">活动 
		<input type="radio"	name="img_Type" id="2" value="2" 
			onclick="show(this)">Banner
		<input type="radio" name="img_Type" id="3" value="3"
			onclick="show(this)">图标
<!--	  	<input type="radio" name="img_Type" id="4" value="4"
			onclick="show(this)">闪屏
 		<input type="radio" name="img_Type" id="5" value="5"
			onclick="show(this)">gym -->
	
		<div id="c" style="margin: 20px; border: 2px; display: none">
			<table>
				<tr>
					<td style="width: 70px">活动名称</td>
					<td style="width: 220px"><input type="text" name="eventName"
						id="eventName" size="35" maxlength="45" value="${event_name}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">活动标签</td>
					<td style="width: 220px"><input type="text" name="tag"
						id="tag" size="35" maxlength="45" value="${tag}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">开始日期</td>
					<td style="width: 220px"><input type="text" name="eventStartDate"
						id="eventStartDate" size="35" maxlength="10" value="${event_start_date}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*请按照 yyyymmdd 格式输入</td>
				</tr>
				<tr>
					<td style="width: 70px">结束日期</td>
					<td style="width: 220px"><input type="text" name="eventEndDate"
						id="eventEndDate" size="35" maxlength="10" value="${event_end_date}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*请按照 yyyymmdd 格式输入</td>
				</tr>
				
				<tr>
					<td style="width: 70px">开始时间</td>
					<td style="width: 220px"><input type="text" name="eventTime"
						id="eventTime" size="35" maxlength="4" value="${event_time}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatTime(this)" /></td>
					<td>*请按照 hhmm (24-hour) 格式输入</td>
				</tr>
				<tr>
					<td style="width: 70px">活动链接</td>
					<td style="width: 220px"><input type="text" name="eventLink"
						id="eventLink" size="35" maxlength="200" value="${event_link}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">活动简介</td>
					<td style="width: 220px"><textArea name="eventDesc"
							id="eventDesc" cols="30" rows="4">${event_desc}</textArea></td>
				</tr>
				<tr>
					<td style="width: 70px">活动地址</td>
					<td style="width: 220px"><input type="text" name="eventPlace"
						id="eventPlace" size="35" maxlength="45" value="${event_place}" /></td>
				</tr>
				<tr>
					<td>添加图片</td>
					<td colspan="2"><input type="file" id="iPhone4IMG" name="iPhone4IMG" size="35" />
					</td>
				</tr>
<!-- 			<tr>
					<td>iPhone5适用图片</td>
					<td colspan="2"><input type="file" id="iPhone5IMG" name="iPhone5IMG" size="35" />
					</td>
				</tr>
				<tr>
					<td>iPhone6适用图片</td>
					<td colspan="2"><input type="file" id="iPhone6IMG" name="iPhone6IMG" size="35" />
					</td>
				</tr>
				<tr>
					<td>iPhone6P适用图片</td>
					<td colspan="2"><input type="file" id="iPhone6PIMG" name="iPhone6PIMG" size="35" />
					</td>
				</tr> -->
			</table>
		</div>
		<div id="d" style="margin: 20px; border: 2px; display: none">
			<table border="0">
				<tr>
					<td style="width: 70px">开始日期</td>
					<td style="width: 220px"><input type="text" name="startDate"
						id="startDate" size="35" maxlength="10" value="${startDate}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*请按照 yyyymmdd 格式输入</td>
				</tr>
				<tr>
					<td>结束日期</td>
					<td><input type="text" name="endDate" id="endDate" size="35"
						maxlength="10" value="${endDate}" onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*请按照 yyyymmdd 格式输入</td>
				</tr>
				<tr>
					<td>添加图片</td>
					<td colspan="2"><input type="file" id="event_def" name="event_def" size="35">
					</td>
				</tr>
<!-- 				<tr>
					<td>fri_def适用图片</td>
					<td colspan="2"><input type="file" id="fri_def" name="fri_def" size="35">
					</td>
				</tr>
				<tr>
					<td>pk_def适用图片</td>
					<td colspan="2"><input type="file" id="pk_def" name="pk_def" size="35">
					</td>
				</tr>
				<tr>
					<td>metal_def适用图片</td>
					<td colspan="2"><input type="file" id="metal_def" name="metal_def" size="35">
					</td>
				</tr> -->
			</table>
		</div>
		<div id="loginpictureDiv" style="margin: 20px; border: 2px; display: none">
			<table>
				<tr>
					<td>添加图片</td>
					<td colspan="2"><input type="file" id="iPhone5IMG" name="iPhone5IMG" size="35" />
					</td>
				</tr>
			</table>
		</div>
		<div id="gymDiv" style="margin: 20px; border: 2px; display: none">
			<table>
				<tr>
					<td>gymCsv</td>
					<td colspan="2"><input type="file" id="gymCsv" name="gymCsv" size="35">
					</td>
				</tr>
			</table>
		</div>
		<br> <input type="submit" value="确认"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="返回" onclick="back();">
			 <input type="button" value="重置" onclick="clearAll();">

	</form>