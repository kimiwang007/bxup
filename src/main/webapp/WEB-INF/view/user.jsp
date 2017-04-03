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
<head>
<title>resources.jsp</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet"/>
<link href="./resources/css/datatables.min.css" rel="stylesheet"/>
<link href="./resources/css/rosy-standard.css" rel="stylesheet"/>
<link href="./resources/css/datepicker.css" rel="stylesheet"/>
<link href="./resources/css/bxadmin.css" rel="stylesheet"/>
</head>	
<body>
<div class="container" style="width:100%;">
	<div class="Toglle col-xs-12">
		<h2>用户列表</h2>	
	</div>
   	<c:if test="${not empty message}">
		<div role="alert" class="Toglle col-xs-12">
			<p>${message}</p>
		</div>
	</c:if>        
     <div class="col-xs-12">        
      	<input type="button"  class="btn btn-primary" value="新建用户" onclick="javascript:window.location.href='./userInfoAdd'"/>
      	<input type="button"  class="btn btn-primary" value="用户一览CSV取得" onclick="exportConfirm()"/>
		<input type="button"  class="btn btn-primary" value="返回" onclick="back();"/>
     </div>
     <div class="Toglle col-xs-12">  
		<table id="resourceTable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="3%">No.</th>
					<th width="5%">名称</th>
					<th width="7%">手机号</th>
					<th width="7%">微信号</th>
					<th width="7%">平台ID</th>
					<th width="3%">身高</th>
					<th width="3%">体重</th>
					<th width="3%">性别</th>
					<th width="3%">年龄</th>
					<th width="3%">体脂率</th>
					<th width="5%">最后登入时间</th>
					<th width="5%">最后登入IP</th>
					<th width="5%">最后登入设备</th>
					<th width="4%">删除</th>
				</tr>
			</thead>
			<tbody>		
				<c:forEach items="${user}" var="item" varStatus="status">
					<tr>
						<td><c:out value = "${status.count}" /></td>
						<td><c:out value = "${item.nickname}" /></td>
						<td><c:out value = "${item.mobile}" /></td>
						<td><c:out value = "${item.intro}" /></td>
						<td><c:out value = "${item.platform_id}" /></td>
						<td><c:out value = "${item.height}" /></td>
						<td><c:out value = "${item.weight}" /></td>
						<td><c:out value = "${item.sex}" /></td>
						<td><c:out value = "${item.age}" /></td>
						<td><c:out value = "${item.rate_fat}" /></td>
						<td><c:out value = "${item.last_login_time}" /></td>
						<td><c:out value = "${item.last_login_ip}" /></td>
						<td><c:out value = "${item.device_type}" /></td>
						<td>
							<input type="button"  class="btn btn-primary" onclick="delConfirm(${item.user_Id});" value="删除">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script src="./resources/js/jquery-1.12.4.min.js"></script>
<script src="./resources/js/bootstrap.min.js"></script>
<script src="./resources/js/datatables.min.js"></script>
<script src="./resources/js/rosy-common.js"></script>
<script>
$(document).ready(function() {
	var table = $('#resourceTable').DataTable( {
		"pageLength": 25,
		"order": [[ 0, "asc" ]],
		"autoWidth": true
	} );
} );
function delConfirm(itemId){	
	if(window.confirm('确定要删除该用户吗?')){
		javascript:window.location.href='user/user_delete/' + itemId
    }
}
function back(){
	if(window.confirm('是否返回导航画面 ?')){
		javascript:window.location.href='/bxadmin'
     }
}
/**数据库导出确认*/
function exportConfirm(){
    var url = "./user/csvExport"
    window.open(url);
}
</script>  
</body>
</html>