<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>list customer page</title>
    <script type="text/javascript">
    	function isDelete(id){
    		var b = window.confirm("确定删除该用户么？");
    		if(b){
    			window.location.href = "${pageContext.request.contextPath }/servlet/DeleteCustomerServlet?customerid=" + id;
    		}
    	}
    </script>
  </head>
  
  <body style="text-align:center;">
	<c:choose>
	  <c:when test="${!empty(list) }">
	    <h2>客户列表</h2>
	    <table style="text-align:center;" border="1" width="80%">
	    	<tr>
		    	<td>客户姓名</td>
		   		<td>性别</td>
		   		<td>生日</td>
		   		<td>手机</td>
		   		<td>邮箱</td>
		   		<td>爱好</td>
		   		<td>类型</td>
		   		<td>备注</td>
		   		<td>操作</td>
	   		</tr>
	   		<c:forEach var="customer" items="${list }">
	   		<tr>
	   			<td>${customer.name }</td>
		   		<td>${customer.gender }</td>
		   		<td>${customer.birthday }</td>
		   		<td>${customer.cellphone }</td>
		   		<td>${customer.email }</td>
		   		<td>${customer.likes }</td>
		   		<td>${customer.type }</td>
		   		<td>
		   			<c:if test="${fn:length(customer.description)>10 }"> <!-- 如果描述大于10个字符，就截取10个显示 -->
	    				${fn:substring(customer.description,0,10)}
	    			</c:if>
	    			<c:if test="${fn:length(customer.description)==0 }">
	    				无
	    			</c:if>
	    			<c:if test="${fn:length(customer.description)<=10 && fn:length(customer.description)>0}">
	    				${customer.description }
	    			</c:if>
		   		</td>
		   		<td>
		   			<a href="${pageContext.request.contextPath }/servlet/UpdateCustomerUIServlet?customerid=${customer.id}">修改</a>
		   			<a href="javascript:isDelete('${customer.id }')">删除</a>
		   		</td>
		   	</tr>
	   		</c:forEach>
	   </table>
	  </c:when>
	  <c:otherwise>
	  	对不起，您还没有任何客户信息！
	  </c:otherwise>
    </c:choose>
 </body>
</html>
