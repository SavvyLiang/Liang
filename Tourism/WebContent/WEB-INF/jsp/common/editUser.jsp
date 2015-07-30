<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>编辑用户</h1>
	<form action="/Tourism/user/updateUser" method="post">
	    <input type="hidden" name="id" value="${user.id }">
		姓名：<input type="text" name="username" value="${user.username }"><br/>
		邮箱：<input type="email" name="email" value="${user.email }"><br/>
		年龄：<input type="number" name="age" max="120" min="0" value="${user.age }"><br/>
		性别：<input type="text" name="sex" list="sex_list" value="${user.sex }"><br/>
		<datalist id="sexlist">
			<option label="男" value="0" />
			<option label="女" value="1" />
		</datalist>
		<input type="submit" value="编辑">
	</form>
</body>
</html>