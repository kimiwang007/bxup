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
<title>show.jsp</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet"/>
<link href="./resources/css/datatables.min.css" rel="stylesheet"/>
<link href="./resources/css/rosy-standard.css" rel="stylesheet"/>
<link href="./resources/css/datepicker.css" rel="stylesheet"/>
<link href="./resources/css/bxadmin.css" rel="stylesheet"/>
</head>	
<body>
<div class="container" style="width:100%;">
	<div class="Toglle col-xs-12">
		<h2>秀场列表</h2>	
	</div>
   	<c:if test="${not empty message}">
		<div role="alert" class="Toglle col-xs-12">
			<p>${message}</p>
		</div>
	</c:if>        
     <div class="col-xs-12">        
      	<input type="button"  class="btn btn-primary" value="新建秀场" onclick="javascript:window.location.href='./showInfoAdd'"/>
		<input type="button"  class="btn btn-primary" value="返回" onclick="back();"/>
     </div>
     <div class="Toglle col-xs-12">  
		<table id="resourceTable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="3%">No.</th>
					<th width="20%">评论</th>
					<th width="10%">图片1</th>
					<th width="10%">图片2</th>
					<th width="10%">图片3</th>
					<th width="10%">图片4</th>
					<th width="8%">日期</th>
					<th width="6%">操作</th>
				</tr>
			</thead>
			<tbody>		
				<c:forEach items="${show}" var="item" varStatus="status">
					<tr>
						<td><c:out value = "${status.count}" /></td>
						<td><c:out value = "${item.description}" /></td>
						<td><a href="${item.pictureurl1}" target="_blank"><c:out value = "${item.img1}" />
						<td><a href="${item.pictureurl2}" target="_blank"><c:out value = "${item.img2}" />		
						<td><a href="${item.pictureurl3}" target="_blank"><c:out value = "${item.img3}" />	
				        <td><a href="${item.pictureurl4}" target="_blank"><c:out value = "${item.img4}" />		
						<td><c:out value = "${item.create_Time}" /></td>
						<td><input type="button" class="btn btn-primary" onclick="delConfirm(${item.id});" value="删除"></td>																										
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
	if(window.confirm('你确定要删除这个秀场吗?')){
		javascript:window.location.href='show/show_delete/' + itemId
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