<%@ page language="java" contentType="text/html;charset=MS932"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Insert title here</title>
</head>

<body>
<h2>不好，这里发生了一些错误</h2>
    <br><input type="button"  class="blue_btn" value="Back" onclick="javascript:window.location.href='./resources'"/>
</body>

</html>