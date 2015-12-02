<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>Add customer page</title>
    <script type="text/javascript">
    	function doSubmit() {
			var likes = "";
			var pres = document.getElementsByName("like");
			for(var i = 0; i < pres.length; i++) {
				if(pres[i].checked == true){
					likes = likes + pres[i].value + ",";
				}
			}
			likes = likes.substr(0, likes.length-1);//删掉最后一个逗号
			
			var input = document.createElement("input");
			input.type = "hidden";
			input.name = "likes";
			input.value = likes;
			
			document.getElementById("customer").appendChild(input);
		}
    </script>
  </head>
  
  <body style="text-align:center;">
  	<h2>添加新客户</h2>
    <form id="customer" action="${pageContext.request.contextPath }/servlet/UpdateCustomerServlet" method="post" onsubmit="return doSubmit()">
    	<input type="hidden" name="id" value="${customer.id }"><!-- 为了将用户的id号也带过去 -->
    	<table style="text-align:left;" border="1">
    		<tr>
    			<td>
    				客户姓名：
    			</td>
    			<td>
    				<input type="text" name="name" value="${customer.name }"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				客户性别：
    			</td>
    			<td>
    				<input type="radio" name="gender" value="男" ${customer.gender=='男'?'checked':'' }/>男
    				<input type="radio" name="gender" value="女" ${customer.gender=='女'?'checked':'' }/>女
    			</td>
    		</tr>
    		<tr>
    			<td>
    				客户爱好：
    			</td>
    			<td>
    				<c:forEach var="pre" items="${preferences }">
    					<input type="checkbox" name="like" value="${pre }" ${fn:contains(customer.likes,pre)?'checked':'' }>${pre }
    				</c:forEach>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				客户生日：
    			</td>
    			<td>
    				<input type="text" name="birthday" value="${customer.birthday }"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				客户电话：
    			</td>
    			<td>
    				<input type="text" name="cellphone" value="${customer.cellphone }"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				客户邮箱：
    			</td>
    			<td>
    				<input type="text" name="email" value="${customer.email }"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				客户类型：
    			</td>
    			<td>
    				<c:forEach var="tp" items="${types }">
    					<input type="radio" name="type" value="${tp }" ${customer.type==tp?'checked':'' }>${tp }
    				</c:forEach>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				备注：
    			</td>
    			<td>
    				<textarea rows="5" cols="50" name="description">${customer.description }</textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2" style="text-align:center;">
    				<input type="reset" value="清空"/>
    				<input type="submit" value="提交"/>
    			</td>  			
    		</tr>
    	</table>
    </form>
  </body>
</html>
