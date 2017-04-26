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
<title>coach.jsp</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet"/>
<link href="./resources/css/datatables.min.css" rel="stylesheet"/>
<link href="./resources/css/rosy-standard.css" rel="stylesheet"/>
<link href="./resources/css/datepicker.css" rel="stylesheet"/>
<link href="./resources/css/bxadmin.css" rel="stylesheet"/>
</head>	
<body>
<div class="container" style="width:100%;">
	<div class="Toglle col-xs-12">
		<h2>教练列表</h2>	
	</div>
   	<c:if test="${not empty message}">
		<div role="alert" class="Toglle col-xs-12">
			<p>${message}</p>
		</div>
	</c:if>        
     <div class="col-xs-12">        
      	<input type="button"  class="btn btn-primary" value="新建教练" onclick="javascript:window.location.href='./coach/coachInfo'"/>
		<input type="button"  class="btn btn-primary" value="返回" onclick="back();"/>
     </div>
     <div class="Toglle col-xs-12">  
		<table id="resourceTable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="3%">No.</th>
					<th width="5%">名字</th>
					<th width="10%">照片</th>
					<th width="3%">性别</th>
					<th width="3%">年龄</th>
					<th width="3%">省</th>
					<th width="5%">市</th>
					<th width="5%">地址</th>
					<th width="5%">档案</th>
					<th width="5%">荣誉</th>
					<th width="5%">就职健身房</th>
					<th width="3%">认证</th>
					<th width="5%">标签</th>
					<th width="3%">热度</th>
					<th width="10%">图片1</th>
					<th width="10%">图片2</th>
					<th width="10%">图片3</th>
					<th width="10%">图片4</th>
					<th width="10%">图片5</th>
					<th width="10%">操作</th>
				</tr>
			</thead>
			<tbody>		
				<c:forEach items="${coach}" var="item" varStatus="status">
					<tr>
						<td><c:out value = "${status.count}" /></td>
						<td><c:out value = "${item.name}" /></td>
						<td><a href="${item.pictureurl}" target="_blank"><c:out value = "${item.avatar}" /></a></td>
						<td><c:out value = "${item.sex}" /></td>
						<td><c:out value = "${item.age}" /></td>
						<td><c:out value = "${item.province}" /></td>
						<td><c:out value = "${item.city}" /></td>
						<td><c:out value = "${item.address}" /></td>
						<td><c:out value = "${item.profile}" /></td>							
						<td><c:out value = "${item.honor}" /></td>
						<td><c:out value = "${item.gym_name}" /></td>
						<td><c:out value = "${item.approvedfg}" /></td>
						<td><c:out value = "${item.tag}" /></td>
						<td><c:out value = "${item.hot}" /></td>
						<td><a href="${item.picture1}" target="_blank"><c:out value = "${item.pictureName1}" /></a></td>
						<td><a href="${item.picture2}" target="_blank"><c:out value = "${item.pictureName2}" /></a></td>
						<td><a href="${item.picture3}" target="_blank"><c:out value = "${item.pictureName3}" /></a></td>
						<td><a href="${item.picture4}" target="_blank"><c:out value = "${item.pictureName4}" /></a></td>
						<td><a href="${item.picture5}" target="_blank"><c:out value = "${item.pictureName5}" /></a></td>
						<td>
							<input type="button"  class="btn btn-primary" onclick="javascript:window.location.href='coach/coach_edit/${item.id}'" value="编辑">
							<input type="button"  class="btn btn-primary" onclick="delConfirm(${item.id});" value="删除">
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
	if(window.confirm('确定要删除该教练吗?')){
		javascript:window.location.href='coach/coach_delete/' + itemId
    }
}
function back(){
	if(window.confirm('是否返回导航画面 ?')){
		javascript:window.location.href='/bxadmin'
     }
}
</script>
</body>
</html>