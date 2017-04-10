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
			<h2>活动列表</h2>	
		</div>
    	<c:if test="${not empty message}">
			<div role="alert" class="Toglle col-xs-12">
				<p>${message}</p>
			</div>
		</c:if>        
        <div class="col-xs-12">        
        	<input type="button"  class="btn btn-primary" value="新建活动" onclick="javascript:window.location.href='./eventAdd'"/>
			<input type="button"  class="btn btn-primary" value="返回" onclick="back();"/>
        </div>
        <div class="Toglle col-xs-12">  
			<table id="resourceTable" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th width="3%">No.</th>
						<th width="8%">活动名称</th>
						<th width="8%">标签</th>
						<th width="8%">开始日期</th>
						<th width="8%">结束日期</th>
						<th width="8%">开始时间</th>
						<th width="14%">活动链接</th>
						<th width="11%">活动简介</th>	
						<th width="11%">活动地点</th>	
						<th width="6%">分类</th>	
						<th width="6%">上架</th>
						<th width="10%">操作</th>			
					</tr>
				</thead>
				<tbody>					
					<c:forEach items="${resources}" var="item" varStatus="status">
						<tr>
							<td><c:out value = "${status.count}" /></td>
							<td><c:out value = "${item.event_name}" /></td>
							<td><c:out value = "${item.tag}" /></td>
							<td><c:out value = "${item.event_start_date}" /></td>
							<td><c:out value = "${item.event_end_date}" /></td>
							<td><c:out value = "${item.timem}" /></td>
							<td><c:out value = "${item.event_link}" /></td>							
							<td><c:out value = "${item.event_desc}" /></td>
							<td><c:out value = "${item.event_place}" /></td>
							<td>
								<c:choose>
									<c:when test="${item.img_Type == 1}">
										活动
									</c:when>
									<c:when test="${item.img_Type == 2}">
										Banner
									</c:when>
									<c:when test="${item.img_Type == 3}">
										图标
									</c:when>
								</c:choose>
							</td>
							<td>
								<c:if test="${item.shelves == 1}">
									<input type="button"  class="btn btn-primary" onclick="javascript:window.location.href='resources/event_shelves/${item.id}'" value="上架">
								</c:if>
								<c:if test="${item.shelves == -1}">
									<input type="button"  class="btn btn-danger" onclick="javascript:window.location.href='resources/event_shelves/${item.id}'" value="下架">
								</c:if>
							</td>
							<td>
								<input type="button"  class="btn btn-primary" onclick="javascript:window.location.href='resources/event_edit/${item.id}'" value="编辑">
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
    	if(window.confirm('确定要删除该活动吗?')){
    		javascript:window.location.href='resources/event_delete/' + itemId
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