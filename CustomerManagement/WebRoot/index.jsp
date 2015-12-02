<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>home page</title>
  </head>
  
  <frameset rows="20%,*">
  	<frame src="${pageContext.request.contextPath }/servlet/HeaderUIServlet" name="head">
  	<frame src="${pageContext.request.contextPath }/servlet/BodyUIServlet" name="body">
  </frameset> 
  <body>   
  </body>
</html>
