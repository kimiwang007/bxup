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
<title>choose.jsp</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet"/>
<link href="./resources/css/datatables.min.css" rel="stylesheet"/>
<link href="./resources/css/rosy-standard.css" rel="stylesheet"/>
<link href="./resources/css/datepicker.css" rel="stylesheet"/>
<link href="./resources/css/bxadmin.css" rel="stylesheet"/>
</head>	
<body>
	<div class="container" style="width:100%;">
		<div class="Toglle col-xs-12">
			<h2>精选列表</h2>	
		</div>
    	<c:if test="${not empty message}">
			<div role="alert" class="Toglle col-xs-12">
				<p>${message}</p>
			</div>
		</c:if>        
        <div class="col-xs-12">        
			<input type="button"  class="btn btn-primary" value="新建精选" onclick="javascript:window.location.href='./subscribeAdd/choose'"/>
			<input type="button"  class="btn btn-primary" value="推荐设定" onclick="setFeedIMG();"/>
		    <input type="button"  class="btn btn-primary" value="返回" onclick="back();"/>
        </div>
        <div class="Toglle col-xs-12">  
			<table id="resourceTable" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th width="5%">No.</th>
						<th width="6%">推荐</th>
						<th width="10%">标题</th>
						<th width="10%">标签</th>
						<th width="12%">URL</th>
						<th width="20%">图片</th>	
						<th width="20%">推荐图片</th>	
						<th width="7%">上架</th>
						<th width="10%">操作</th>	
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${choose}" var="item" varStatus="status">
						<tr>
							<td><c:out value = "${status.count}" /><input name='subscribe_type' type=hidden value="${item.subscribe_type}"></td>
							<td>
								<c:choose>
									<c:when test="${item.feedImg != null}">
										<input type="checkbox" name="feedCheck" value="${item.id}" checked>
									</c:when>
									<c:otherwise>
										<input type="checkbox" name="feedCheck" value="${item.id}">
									</c:otherwise>
								</c:choose>
							</td>	
							<td><c:out value = "${item.title}" /></td>
							<td><c:out value = "${item.tab}" /></td>
							<td><c:out value = "${item.url}" /></td>
							<td><a href="${item.imgUrl}" target="_blank"><c:out value = "${item.img}" /></a></td>
							<td><a href="${item.feedImgUrl}" target="_blank"><c:out value = "${item.feedImg}" /></a></td>
							<td>
								<c:if test="${item.shelves == -1}">
									<input type="button"  class="btn btn-primary" onclick="javascript:window.location.href='choose/choose_shelves/${item.id}'" value="上架">
								</c:if>
								<c:if test="${item.shelves == 1}">
									<input type="button"  class="btn btn-danger" onclick="javascript:window.location.href='choose/choose_shelves/${item.id}'" value="下架">
								</c:if>
							</td>
							<td>
								<input type="button"  class="btn btn-primary" onclick="javascript:window.location.href='choose/choose_edit/${item.id}'" value="编辑">
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
    		javascript:window.location.href='choose/choose_delete/' + itemId
        }
    }
    function setFeedIMG(){
    	if($('input[name="feedCheck"]:checked').size() > 2){
    		alert("最大可以选择两项");
    		return false;
    	}
    	var chk_value ="'";    
    	$('input[name="feedCheck"]:checked').each(function(){  
    		chk_value = chk_value + $(this).val() + "'";		
    	});    
    	javascript:window.location.href='./choose/' + chk_value;
    }
    function back(){
    	if(window.confirm('是否返回导航画面 ?')){
    		javascript:window.location.href='/bxadmin'
         }
    }
    </script> 
</body>
</html>