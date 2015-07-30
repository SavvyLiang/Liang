<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理页面</title>
<script type="text/javascript">
	function del(id) {
		$.get("/Tourism/user/delUser?id=" + id, function(data){
			if ("success" == data) {
				alert("删除成功");
				window.location.reload();
			} else {
				alert("删除失败");
			}
		});
	}
</script>
</head>
<body>
	<h6><a href="/Tourism/user/registerUser">添加用户</a></h2>
	<table border="1">
		<tr>
		 	<th>姓名</th>
		 	<th>邮箱</th>
		 	<th>年龄</th>
		 	<th>性别</th>
		 	<th>操作</th>
	   </tr>
	   <c:if test="${!empty userList }">
	   	 <c:forEach items="${userList }" var="user">
	   	 	<tr>
	   	 		<td>${user.username }</td>
	   	 		<td>${user.email }</td>
	   	 		<td>${user.age }</td>
	   	 		<td>${user.sex }</td>
	   	 		<td>
	   	 			<a href="/Tourism/user/showUser?id=${user.id }">编辑</a>
	   	 			<a href="javascript:del('${user.id }')">删除</a>
	   	 		</td>
	   	 	</tr>
	   	 </c:forEach>
	   </c:if>
	</table>
</body>
</html>