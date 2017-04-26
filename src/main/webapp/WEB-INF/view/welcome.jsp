<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="true">
<head>
<title>welcome.jsp</title>
<SCRIPT Language="JavaScript">

	function onSubmit1(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome1";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit2(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome2";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit3(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome3";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit4(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome4";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit5(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome5";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit6(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome6";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit8(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome8";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit9(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome9";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit7(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome7";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit10(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome10";
		form.submit();
		form.actionCmd.value = "";
    }
	function onSubmit11(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome11";
		form.submit();
		form.actionCmd.value = "";
    }
</script>
</head>

<body>
	<form>
	<table>
		<tr>
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit1();">活动项目一览</a></td>
		</tr>
		
		<tr>		
	    <td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit2();">教练员信息一览</a></td>
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit3();">健身房信息一览</a></td>	
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit5();">知道一览</a></td>	
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit6();">精选一览</a></td>	
		</tr>
	    <tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit9();">头条一览</a></td>	
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit7();">用户一览</a></td>	
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit8();">秀场一览</a></td>	
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit10();">闪屏一览</a></td>	
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit4();">客户反馈信息</a></td>	
		</tr>
		<tr>
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit11();">社区一览</a></td>	
		</tr>
	</table>	
	</form>
</body>


</html>
