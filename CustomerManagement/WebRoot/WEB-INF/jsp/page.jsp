<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>page</title>
    <script type="text/javascript">
    	function goWhich(input){
    		var pagenum = input.value;
    		if(pagenum == null || pagenum == ""){
    			alert("请输入正确的页码！");
    			return;
    		}
    		if(pagenum > ${page.totalPage} || pagenum < 1){
    			alert("您输入的页码无效！请重新输入！");
    			input.value = "";
    			return;
    		}
    		if(!pagenum.match("\\d+")){ //js中的正则表达式
    			alert("请输入数字！");
    			input.value = "";
    			return;
    		}
    		window.location.href = "${page.url}?pageNum=" + pagenum;
    	}
    </script>
  </head>
  
  <body>
     当前第[${page.pageNum }]页&nbsp;&nbsp;&nbsp;
    <c:if test="${page.pageNum != 1 }">
    	<a href="${page.url}?pageNum=${page.pageNum - 1}">上一页</a>
    </c:if>
    <c:forEach var="pagenum" begin="${page.startPage }" end="${page.endPage }">
    	<a href="${page.url}?pageNum=${pagenum}">${pagenum }</a>
    </c:forEach>
    <c:if test="${page.pageNum != page.totalPage }">
    	<a href="${page.url}?pageNum=${page.pageNum + 1}">下一页</a>
    </c:if>
     &nbsp;&nbsp;&nbsp; 共[${page.totalPage }]页, 共${page.totalRecord }条记录
    <input type="text" id="pagenum" style="width:40px;">
	<input type="button" value="GO" onclick="goWhich(document.getElementById('pagenum'))">
  </body>
</html>
